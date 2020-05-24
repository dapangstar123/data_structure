# java 实现基于霍夫曼编码的单文件的压缩与解压缩
## Introduce
* 功能：压缩与解压单个文件
* 详情：利用霍夫曼算法生成输入文件的霍夫曼编码，并转为二进制字节流输出从而达到压缩的效果。

## Running Command
* 压缩：java -jar Compress.jar 0 test.fasta test.fasta.zip
* 解压缩：java -jar Compress.jar 1 test.fasta.zip test.txt

### 说明
* 只是简单实现霍夫曼编码思想，可能存在一些问题。
