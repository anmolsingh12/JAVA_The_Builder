import java.io.*;

public class Utils {

    public void compileRunSingleJavaFile(String src, String fileName)
    {
        if (!src.endsWith(File.separator))
            src += File.separator;

        File file = new File(fileName);

        //String str = file.getName().substring(0, file.getName().length() - 5);

        File fi = new File("run.bat");

        FileOutputStream fos;
        DataOutputStream dos;

        FileWriter writer = null;

        try {
            String newLine = System.getProperty("line.separator");

            fos = new FileOutputStream(fi);
            dos = new DataOutputStream(fos);

            dos.writeBytes("cd " +src+ "\n");
            dos.writeBytes(newLine);

            dos.writeBytes("javac "+ fileName + ".java\n");
            dos.writeBytes(newLine);

            dos.writeBytes("java " +fileName+ "\n");
            dos.writeBytes(newLine);

            Process p = Runtime.getRuntime().exec("cmd /c start run.bat");

            p.waitFor();

            fi.delete();
        } catch (Exception f) {
            System.out.println(f.getMessage());
        }
    }

//*************************************************************************************************

    public static void fileFinder(String sourcePath)
    {
        File root = new File(sourcePath);

        if (!root.exists())
        {
            return;
        }

        File[] list_file = root.listFiles();

        if (list_file == null)
            return;

        for (File var : list_file)
        {
            if (var.isDirectory())
            {
                //stringArrayList.add(var.getAbsolutePath());
                //fileFinder(var.getAbsolutePath());
            }
        }
    }

    //******************************************************************************************

    public void compileRunJavaProject(String src, String className)
    {

        File fi = new File("run.bat");

        FileOutputStream fos;
        DataOutputStream dos;

        FileWriter writer = null;

        try {
            String newLine = System.getProperty("line.separator");

            fos = new FileOutputStream(fi);
            dos = new DataOutputStream(fos);

            dos.writeBytes("cd /d " +src+ "\n");
            dos.writeBytes(newLine);

            dos.writeBytes("javac *.java\n");
            dos.writeBytes(newLine);

            dos.writeBytes("java " + className + "\n");
            dos.writeBytes(newLine);

            Process p = Runtime.getRuntime().exec("cmd /c start run.bat");

            p.waitFor();

            fi.delete();

        }

        catch (Exception f)
        {
            System.out.println(f.getMessage());
        }
    }
}