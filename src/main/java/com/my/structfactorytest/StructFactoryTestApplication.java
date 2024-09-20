package com.my.structfactorytest;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.my.structfactorytest.configuration.SwitchDB;
import com.my.structfactorytest.entity.PidToExe;
import com.my.structfactorytest.entity.PortExecut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;


//@SpringBootApplication(exclude = {
//        DataSourceAutoConfiguration.class,
//        DataSourceTransactionManagerAutoConfiguration.class,
//        DruidDataSourceAutoConfigure.class ,
//        HibernateJpaAutoConfiguration.class})
@SpringBootApplication
public class StructFactoryTestApplication {

    public static void main(String[] args) {

        // 要执行的命令
        String command = "cmd.exe /c dir";
        String command1 = " cmd.exe /c netstat -a -n";

        List<PortExecut> portExecuts = new ArrayList<>();
        List<String> portList = new ArrayList<>();


        // 使用Runtime执行命令
        try {
            Process process = Runtime.getRuntime().exec(command1);
            // 读取命令执行结果
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK"));
            String line;
            while ((line = reader.readLine()) != null) {
                //hash值为0的时候isEmpty判断不住
                if (line.equals("")){
                    continue;
                }
                //判断字符串中是否包含枚举中的值，没有则跳过改行
                String str = line;
                boolean containsAny = Stream.of(PortStatueType.values())
                        .anyMatch(e -> str.contains(e.name()));
                if (!containsAny){
                    continue;
                }
                String[] parts = line.split("\\s+");
                PortExecut portExecut = new PortExecut(parts[1],parts[2],parts[3],parts[4]);
                portExecuts.add(portExecut);
//                System.out.println(line);
            }
            // 等待命令执行完成
            process.waitFor();
            // 关闭流
            reader.close();
//            System.out.println(portExecuts);
            //遍历集合，得到端口号，之后根据端口号去找寻对应的exe文件
            for (int i = 0; i < portExecuts.size(); i++) {
                String externalAddress = portExecuts.get(i).getExternalAddress();
                String externalAddressPort = "";
                if (externalAddress.contains(":")){
                    int lastColonIndex = portExecuts.get(i).getExternalAddress().lastIndexOf(":");
                    if (lastColonIndex < externalAddress.length() -1){
                        externalAddressPort = externalAddress.substring(lastColonIndex + 1);
                    }
                    portList.add(externalAddressPort);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //将portList集合去重
        Set<String> set = new HashSet<>(portList);
        portList.clear();
        portList.addAll(set);
//            System.out.println(portList);
        List<String> command2s = new ArrayList<>();
        for (int i = 0; i < portList.size(); i++) {
            String command2 = " cmd.exe /c netstat -ano | findstr :" + portList.get(i);
            command2s.add(command2);
        }
//        System.out.println(command2s);
        List<String> pids = new ArrayList<>();
        for (int i = 0; i < command2s.size(); i++) {
            // 使用Runtime执行命令
            try {
                Process process1 = Runtime.getRuntime().exec(command2s.get(i));
                // 读取命令执行结果
                BufferedReader reader1 = new BufferedReader(new InputStreamReader(process1.getInputStream(), "GBK"));
                String line1;
                while ((line1 = reader1.readLine()) != null) {
                    if (line1.equals("")){
                        continue;
                    }
//                        System.out.println(line1);
                    String[] pid = line1.split("\\s+");
                    pids.add(pid[5]);

                }
                // 等待命令执行完成
                process1.waitFor();
                // 关闭流
                reader1.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        System.out.println(pids);
        Set<String> pidSet = new HashSet<>(pids);
        pids.clear();
        pids.addAll(pidSet);
//        System.out.println(pids);

        List<PidToExe> pidToExes = new ArrayList<>();
        for (int i = 0; i < pids.size(); i++) {
            String command3 = "tasklist /fi \"pid eq " + pids.get(i)+  "\"";
            try{
                Process process2 = Runtime.getRuntime().exec(command3);

                BufferedReader reader2 = new BufferedReader(new InputStreamReader(process2.getInputStream(), "GBK"));
                String line2;
                while((line2 = reader2.readLine()) != null){
//                    System.out.println(line2);
                    if (line2.equals("") || line2.contains("PID") || line2.contains("=") || line2.contains("信息")){
                        continue;
                    }
                    String[] task = line2.split("\\s+");
//                    System.out.println(line2);
//                    System.out.println(task);
                    PidToExe pidToExe = new PidToExe(task[0],task[1],task[2],task[3],task[4] + "k");
                    pidToExes.add(pidToExe);
                }
                process2.waitFor();
                reader2.close();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(String.format("|%-30s|%-10s|%-15s|%-10s|%-10s|","Name","PID","SessionName","Session#","MemoryUse"));
        System.out.println(String.format("|%30s|%10s|%15s|%10s|%10s|","---","---","---","---","---"));

        for(PidToExe p : pidToExes){
            System.out.println(String.format("|%-30s|%-10s|%-15s|%-10s|%-15s|",p.getName(),p.getPid(),p.getSessionName(),p.getSessionNumber(),p.getMemoryUse()));
        }



//        SpringApplication.run(StructFactoryTestApplication.class, args);
    }

}
