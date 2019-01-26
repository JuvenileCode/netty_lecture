package org.struggle.netty.handler3;

/**
 * @Auther: Bin.L
 * @Date: 2018/12/18 22:11
 * @Description:
 */
public class PersonProtocol {

    private int length;

    private byte[] content;

    public PersonProtocol() {
    }

    public PersonProtocol(int length, byte[] content) {
        this.length = length;
        this.content = content;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
