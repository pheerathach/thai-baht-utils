# Thai Baht Utils
ไลบรารีสำหรับแปลงจำนวนตัวเลขเงินบาทให้อยู่ในรูปตัวอักษร

## การใช้งาน
```
String example1 = ThaiBahtUtils.toText(new BigDecimal("101.50"));
System.out.println(example1); // หนึ่งร้อยเอ็ดบาทห้าสิบสตางค์

String example2 = ThaiBahtUtils.toText(new BigDecimal("2147483647.0"));
System.out.println(example2); // สองพันหนึ่งร้อยสี่สิบเจ็ดล้านสี่แสนแปดหมื่นสามพันหกร้อยสี่สิบเจ็ดบาทถ้วน

String example3 = ThaiBahtUtils.toText(new BigDecimal("-36.50"));
System.out.println(example3); // ลบสามสิบหกบาทห้าสิบสตางค์

String example4 = ThaiBahtUtils.toText(new BigDecimal(".01"));
System.out.println(example4); // หนึ่งสตางค์

String example5 = ThaiBahtUtils.toText(new BigDecimal(".1"));
System.out.println(example5); // สิบสตางค์

String example6 = ThaiBahtUtils.toText(new BigDecimal("1949.21"));
System.out.println(example6); // หนึ่งพันเก้าร้อยสี่สิบเก้าบาทยี่สิบเอ็ดสตางค์

String example7 = ThaiBahtUtils.toText(new BigDecimal("100001"));
System.out.println(example7); // หนึ่ีงแสนเอ็ดบาทถ้วน

String example8 = ThaiBahtUtils.toText(new BigDecimal("0"));
System.out.println(example8); // ศูนย์บาทถ้วน

String example9 = ThaiBahtUtils.toText(new BigDecimal("-0"));
System.out.println(example9); // ศูนย์บาทถ้วน

String example10 = ThaiBahtUtils.toText(new BigDecimal("2.358"));
System.out.println(example10); // สองบาทสามสิบห้าสตางค์
```

## วิธีนำไปใช้

```
<dependency>
  <groupId>io.github.pheerathach</groupId>
  <artifactId>thai-baht-utils</artifactId>
  <version>1.0.0</version>
</dependency>
```
