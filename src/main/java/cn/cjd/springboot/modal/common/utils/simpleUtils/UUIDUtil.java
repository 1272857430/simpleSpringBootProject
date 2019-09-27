package cn.cjd.springboot.modal.common.utils.simpleUtils;

import java.util.UUID;
/**
 * 什么是UUID

 UUID是指在一台机器上生成的数字，它保证对在同一时空中的所有机器都是唯一的。通常平台会提供生成的API。按照开放软件基金会(OSF)制定的标准计算，用到了以太网卡地址、纳秒级时间、芯片ID码和许多可能的数字


 UUID由以下几部分的组合：

 （进程与线程.txt）当前日期和时间，UUID的第一个部分与时间有关，如果你在生成一个UUID之后，过几秒又生成一个UUID，则第一个部分不同，其余相同。

 （2）时钟序列。

 （3）全局唯一的IEEE机器识别号，如果有网卡，从网卡MAC地址获得，没有网卡以其他方式获得


 UUID的唯一缺陷在于生成的结果串会比较长。关于UUID这个标准使用最普遍的是微软的GUID(Globals Unique Identifiers)。在ColdFusion中可以用CreateUUID()函数很简单地生成UUID，其格式为：xxxxxxxx-xxxx- xxxx-xxxxxxxxxxxxxxxx(8-4-4-16)，其中每个 x 是 0-9 或 a-f 范围内的一个十六进制的数字。而标准的UUID格式为：xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx (8-4-4-4-12)，可以从cflib 下载CreateGUID() UDF进行转换。



 作用

 UUID 的目的是让分布式系统中的所有元素，都能有唯一的辨识资讯，而不需要透过中央控制端来做辨识资讯的指定。如此一来，每个人都可以建立不与其它人冲突的 UUID。在这样的情况下，就不需考虑数据库建立时的名称重复问题。目前最广泛应用的 UUID，即是微软的 Microsoft's Globally Unique Identifiers (GUIDs)，而其他重要的应用，则有 Linux ext2/ext3 档案系统、LUKS 加密分割区、GNOME、KDE、Mac OS X 等等。


 应用

 使用UUID的好处在分布式的软件系统中（比如：DCE/RPC, COM+,CORBA）就能体现出来，它能保证每个节点所生成的标识都不会重复，并且随着WEB服务等整合技术的发展，UUID的优势将更加明显。根据使用的特定机制，UUID不仅需要保证是彼此不相同的，或者最少也是与公元3400年之前其他任何生成的通用唯一标识符有非常大的区别。UUID最少在3000+年内不会重复
 通用唯一标识符还可以用来指向大多数的可能的物体。微软和其他一些软件公司都倾向使用全球唯一标识符（GUID），这也是通用唯一标识符的一种类型，可用来指向组建对象模块对象和其他的软件组件。第一个通用唯一标识符是在网络计算机系统（NCS）中创建，并且随后成为开放软件基金会（OSF）的分布式计算环境（DCE）的组件。

 * Created by 170096 on 2018/9/6.
 */
public class UUIDUtil {

    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }

    public static void main(String[] args) {
        System.out.println(getUUID());
        System.out.println(getUUID().length());
    }
}

