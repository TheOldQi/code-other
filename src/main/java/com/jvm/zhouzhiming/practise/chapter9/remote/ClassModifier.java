package com.jvm.zhouzhiming.practise.chapter9.remote;

/**
 * <p>
 * Description: 替换Class文件中的内容.
 * </P>
 * <p>
 * CALLED BY: 齐霞飞
 * </P>
 * <p>
 * UPDATE BY: 齐霞飞
 * </P>
 * <p>
 * CREATE DATE: 2017年9月25日
 * </P>
 * <p>
 * UPDATE DATE: 2017年9月25日
 * </P>
 *
 * @author qixiafei
 * @version 0.0.1-SNAPSHOT
 * @since java 1.7.0
 */
public class ClassModifier {

    /**
     * Class文件中常量池的起始地址偏移.
     */
    private static final int CONSTANT_POOL_COUNT_INDEX = 8;

    /**
     * Constant_utf8_info 常量的tag标志.
     */
    private static final int CONSTANT_UTF8_INFO = 1;

    /**
     * 常量池中11种常量所占的长度，CONSTANT_utf8_info除外，因为它不是定长的.
     */
    private static final int[] CONSTANT_ITEM_LENGTH_ARRAY = {-1, -1, -1, 5, 5, 9, 9, 3, 3, 5, 5, 5, 5};

    /**
     * u1类型的字节数.
     */
    private static final int U1_BYTE_COUNT = 1;

    /**
     * u2类型的字节数.
     */
    private static final int U2_BYTE_COUNT = 2;

    private byte[] classByte;

    public ClassModifier(byte[] classByte) {
        this.classByte = classByte;
    }

    /**
     * 替换class字节数组中关于给定key的utf8常量值.
     *
     * @param oldStr
     * @param newStr
     * @return
     */
    public byte[] modifyUTF8Constant(String oldStr, String newStr) {
        int cpc = getConstantPoolCount();
        int offset = CONSTANT_POOL_COUNT_INDEX + U2_BYTE_COUNT;
        for (int i = 0; i < cpc; i++) {
            int tag = ByteUtils.bytes2Int(classByte, offset, U1_BYTE_COUNT);
            if (tag == CONSTANT_UTF8_INFO) {
                int len = ByteUtils.bytes2Int(classByte, offset + U1_BYTE_COUNT, U2_BYTE_COUNT);
                offset += (U1_BYTE_COUNT + U2_BYTE_COUNT);
                String str = new String(classByte, offset, len);
                if (str.equalsIgnoreCase(oldStr)) {
                    byte[] newBytes = newStr.getBytes();
                    byte[] newStrLen = ByteUtils.int2Bytes(newStr.length(), U2_BYTE_COUNT);
                    classByte = ByteUtils.bytesReplace(classByte, offset - U2_BYTE_COUNT, U2_BYTE_COUNT, newStrLen);
                    classByte = ByteUtils.bytesReplace(classByte, offset, len, newBytes);
                    return classByte;
                } else {
                    offset += len;
                }
            } else {
                offset += CONSTANT_ITEM_LENGTH_ARRAY[tag];
            }
        }
        return classByte;
    }

    /**
     * 获取常量池大小.
     *
     * @return 常量池大小
     */
    public int getConstantPoolCount() {
        return ByteUtils.bytes2Int(classByte, CONSTANT_POOL_COUNT_INDEX, U2_BYTE_COUNT);
    }
}
