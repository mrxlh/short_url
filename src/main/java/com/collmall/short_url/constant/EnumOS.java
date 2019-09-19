package com.collmall.short_url.constant;

/**
 * 操作系统
 * @author
 * @version 2019年9月19日
 * @since JDK1.7
 */
public enum EnumOS {
    /**
     * linux系统
     */
    linux,

    /**
     * macos系统
     */
    macos,

    /**
     * solaris系统
     */
    solaris,

    /**
     * unknown系统
     */
    unknown,

    /**
     * windows系统
     */
    windows;

    /**
     * @return 是否linux
     */
    public boolean isLinux() {
        return this == linux || this == solaris;
    }

    /**
     * @return 是否mac
     */
    public boolean isMac() {
        return this == macos;
    }

    /**
     * @return 是否windows
     */
    public boolean isWindows() {
        return this == windows;
    }


    /**
     * @return EnumOS
     */
    public static EnumOS getOs() {
        String s = System.getProperty("os.name").toLowerCase();

        if (s.contains("win")) {
            return EnumOS.windows;
        }

        if (s.contains("mac")) {
            return EnumOS.macos;
        }

        if (s.contains("solaris")) {
            return EnumOS.solaris;
        }

        if (s.contains("sunos")) {
            return EnumOS.solaris;
        }

        if (s.contains("linux")) {
            return EnumOS.linux;
        }

        if (s.contains("unix")) {
            return EnumOS.linux;
        }
        return EnumOS.unknown;
    }
}