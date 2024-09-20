package com.my.structfactorytest;

public enum PortStatueType {
    /**
    * 无连接是活动的或正在进行的
    */

    CLOSED,

    /**
     * 服务器正在等待进入调用
     */

    LISTENING,

    /**
     * 在发送连接请求后等待匹配的连接请求
     */

    SYN_SENT,

    /**
     * 在收到和发送一个连接请求后等待对方对连接请求的确认
     */

    SYN_RECEIVED,

    /**
     * 代表一个打开的连接，收发数据都可以。
     */

    ESTABLISHED,

    /**
     * 等待远程TCP连接中断请求，或先前的连接中断请求的确认
     */

     FIN_WAIT_1,

    /**
     * 从远程TCP等待连接中断请求
     */

    FIN_WAIT_2,

    /**
     * 等待从本地用户发来的连接中断请求
     */

    CLOSE_WAIT,

    /**
     * 等待远程TCP对连接中断的确认
     */

    CLOSING,

    /**
     * 等待原来发向远程TCP的连接中断请求的确认
     */

    LAST_ACK,

    /**
     * 等待足够的时间以确保远程TCP接收到连接中断请求的确认
     */

    TIME_WAIT,

    /**
     * 等待释放TCP控制块（TCB）。
     */

    DELETE_TC
}
