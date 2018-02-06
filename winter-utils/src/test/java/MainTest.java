import java.io.*;

public class MainTest {
    public static void main(String[] args) {
        File file = new File("D:\\var\\init_data_all.sql");
        if (file.exists()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line = null;
                int cnt = 1;
                String outStr = "";
                int fileNum = 1;
                while ((line = br.readLine()) != null) {
//                    if (!line.contains("KSYS_TMBBANKINFO")&&!line.contains("KACCT_CARBIN_INFO")&&!line.contains("comm")&&line.trim()!="") {
                    if (!line.contains("KSYS_TMBBANKINFO")&&!line.contains("KACCT_CARBIN_INFO")&&!line.contains("comm")) {
                        System.out.println(cnt);
                        if (line.contains(";"))
                            outStr += line + "\n";
                        else
                            outStr += line + " ";
                        if (cnt == 20000) {
                            OutputStream out = new FileOutputStream("D:\\var\\target\\init_data_other_" + fileNum + ".sql");
//                            System.out.println(cnt);
                            out.write(outStr.getBytes("gbk"));
                            out.flush();
                            outStr = "";
                            cnt = 0;
                            fileNum++;
                        }
                        cnt++;
                    }
                }
                OutputStream out1 = new FileOutputStream("D:\\var\\target\\init_data_other_" + fileNum + ".sql");
//                            System.out.println(cnt);
                out1.write(outStr.getBytes("gbk"));
                out1.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
