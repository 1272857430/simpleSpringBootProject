package com.modal.common.utils;

import java.util.Iterator;
import java.util.List;

public final class StringUtils
{

    /**
     * 表示空字符串。
     */
    public static final String Empty = "";

    /**
     * 元素分隔符。
     */
    public static final char ElementSeparatorChar = ',';

    /**
     * 元素分隔符。出于方便考虑，它被表示为一个字符串。
     */
    public static final String ElementSeparator = ",";

    /**
     * 指示指定的 String 对象是否为空引用或空字符串。
     * @param s 一个 String 引用。
     * @return 如果 s 是空引用或空字符串（""），则为 true；否则为 false。
     */
    public static boolean isNullOrEmpty(String s)
    {
        if (s != null)
        {
            return (s.length() == 0);
        }
        return true;
    }

    /**
     * 指示指定的 String 对象是否为空引用、空字符串或者只包含空白字符的字符串。
     * @param s 一个 String。
     * @return 如果 s 是空引用、空字符串（""）或者只包含空白字符的字符串， 则为 true；否则为 false。
     */
    public static boolean isNullOrBlank(String s)
    {
        if ((s == null) || (s.length() == 0) || (s.trim().length() == 0))
        {
            return true;
        }
        return false;
    }

    /**
     * 从字符串检索子字符串。子字符串从指定的字符位置开始。
     * @param s 一个 String。
     * @param startIndex 子字符串的起始字符位置。
     * @return 一个 String，等效于 s 中从 startIndex 处开始的子字符串。 如果 startIndex 等于 s 的长度，则为
     *         Empty。
     */
    public static String substring(String s, int startIndex)
    {
        return substring(s, startIndex, s.length() - startIndex);
    }

    /**
     * 从字符串检索子字符串。子字符串从指定的字符位置开始且具有指定的长度。
     * @param s 一个 String。
     * @param startIndex 子字符串的起始字符位置。
     * @param length 子字符串中的字符数。
     * @return 一个 String，等效于 s 中从 startIndex 开始的、长度为 length 的子字符串。如果 startIndex
     *         与 s 的长度相等且 length 为零，则为 Empty。
     */
    public static String substring(String s, int startIndex, int length)
    {
        if (length == 0)
        {
            return Empty;
        }
        return s.substring(startIndex, startIndex + length);
    }

    /**
     * 将指定字符串中的格式项替换为指定数组中相应 Object 实例的 文本等效项。
     * @param format String，包含零个或多个格式项。
     * @param args 包含零个或多个要格式化的对象的 Object 数组。
     * @return format 的一个副本，其中格式项已替换为 args 中相应 Object 实例的 字符串等效项。
     */
    public static String format(String format, Object[] args)
    {
        StringBuilder sb = new StringBuilder();
        char[] chArray = format.toCharArray();
        int index = 0;
        int length = chArray.length;
        int number = 0;
        char ch;
        int textStart = -1, // 正在处理的文本片断开始位置
        numStart = -1, // 正在处理的数字片断开始位置
        fsStart = -1; // 正在处理的格式片断开始位置

        while (index < length)
        {
            ch = chArray[index];

            // 如果开始数字片断
            if (numStart != -1)
            {
                if ((ch >= '0') && (ch <= '9'))
                {
                    number = number * 10 + (ch - '0');
                }
                else
                {
                    if (ch == '}')
                    {
                        if (number >= args.length)
                        {
                            throw new RuntimeException();
                        }
                        sb.append(args[number].toString());
                        textStart = index + 1;
                    }
                    else if (ch == ':')
                    {
                        if (index + 1 < length)
                        {
                            index++;

                            // 格式片断开始
                            fsStart = index;
                            if (chArray[index] == '}')
                            {
                                index--;
                            }
                        }
                    }
                    numStart = -1;
                }
            }
            // 如果开始格式片断
            else if (fsStart != -1)
            {
                if (ch == '}')
                {
                    sb.append(args[number]);
                    fsStart = -1;
                    textStart = index + 1;
                }
            }
            else
            {
                if ((ch == '{') && (index + 1 < length) && Character.isDigit(chArray[index + 1]))
                {
                    if (textStart != -1)
                    {
                        sb.append(chArray, textStart, index - textStart);
                        textStart = index;
                    }
                    index++;

                    // 数字片断开始
                    numStart = index;
                    number = (chArray[index] - '0');
                }
                else if (-1 == textStart)
                {
                    textStart = 0;
                }
            }
            index++;
        }
        if (textStart != length)
        {
            sb.append(chArray, textStart, length - textStart);
        }
        return sb.toString();
    }

    public static String join(List<?> list, char linker)
    {
        return join(list.iterator(), linker);
    }

    public static String join(Iterator<?> iterator, char linker)
    {
        // 空引用或 0 个元素
        if (null == iterator)
        {
            return null;
        }
        if (!iterator.hasNext())
        {
            return Empty;
        }

        // 进程与线程.txt 个或更多元素
        StringBuilder builder = new StringBuilder();
        do
        {
            if (builder.length() > 0)
            {
                builder.append(linker);
            }
            builder.append(iterator.next().toString());
        }
        while (iterator.hasNext());
        return builder.toString();
    }
}
