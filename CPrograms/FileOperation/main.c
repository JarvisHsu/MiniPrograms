#include <stdio.h>
#include <stdlib.h>
#include <string.h>




void Demo_1(void)
{
    FILE *fp = NULL;   //声明一个文件指针fp，进行打开文件操作；
    char string[512][512];   //声明一个String数组，存储被操纵文件；
    int i = 0;
    /*打开文件*/
    if((fp = fopen("./data.txt","r")) == NULL){
        printf("Open File Failed\n");
        exit(1);
    }
    printf("Open File Sccuess\n\n");
    printf("文件指针的地址:%X\n",(unsigned int)(long)fp);

}




void File_Operation(void)
{
    FILE *fp = NULL;   //声明一个文件指针fp，进行打开文件操作；
    char string[512][512];   //声明一个String数组，存储被操纵文件；
    int i = 0;
    /*打开文件*/
    if((fp = fopen("./data.txt","r")) == NULL){
        printf("Open File Failed\n");
        exit(1);
    }
    printf("Open File Sccuess\n\n");
    printf("文件指针的地址:%X\n",(unsigned int)(long)fp);
    int j=0;
    /*读取文件信息*/

    while(!feof(fp) &&i<512){
        //fscanf(fp,"%s",string[i++]);
        fscanf(fp,"\n%[^\n]",(char *)&string[i++]);
        //fgets("%s",2,fp);

    }
    printf("Read Completion\n\n");

    /*加密前*/
    //for(int j = 0;j<i+1;j++){
    //   printf("%s\n",string[j]);
    //}
    printf("Operating...\n");
    /*加密*/
    for(int j = 0;j<i+1;j++){
        for(int k = 0;string[j][k]!= '\0';k++){
            if(('a'<=string[j][k]&&'w'>=string[j][k])||('A'<=string[j][k]&&'W'>=string[j][k])){
                string[j][k]+=3;
            }
            if(('x'<=string[j][k]&&'z'>=string[j][k])||('X'<=string[j][k]&&'Z'>=string[j][k])){
                string[j][k]-=23;
            }
        }
    }
    /*加密后*/
    //for(int j = 0;j<i+1;j++){
    //    printf("%s\n",string[j]);
    //}

    FILE *fr;
    fr = fopen("./crpdata.txt","w");
    for(int j = 0; j<i+1;j++){
        fprintf(fr,"%s\n",(char *)&string[j]);
    }
    fclose(fr);
    fclose(fp);
    printf("Operation Success!\n");

}

int main()
{
    File_Operation();
    //Demo_1();


    return 0;
}
