package ejemplos.semana08.archivosTexto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MergePersonFiles {
    static void main() {
        String file1="src/ejemplos/semana08/archivosTexto/contactos1.txt";
        String file2="src/ejemplos/semana08/archivosTexto/contactos2.txt";
        String fileOut="src/ejemplos/semana08/archivosTexto/contactosUnidos.txt";
        try {
            Scanner scFile1 = new Scanner(new File(file1));
            Scanner scFile2 = new Scanner(new File(file2));
            String delimiters="\r\n|\r|\n|;";
            scFile1.useDelimiter(delimiters);
            scFile2.useDelimiter(delimiters);
            PrintWriter out = new PrintWriter(fileOut);

            //leo la primera vez a fuera del ciclo
            String[] line1=null, line2=null;
            while(scFile1.hasNextLine() && scFile2.hasNextLine()) {
                if(line1==null){
                    line1=scFile1.nextLine().split(";");
                }
                if(line2==null){
                    line2=scFile2.nextLine().split(";");
                }
                int id1 = Integer.parseInt(line1[0]);
                int id2 = Integer.parseInt(line2[0]);
                if(id1==id2){
                    //mezclo
                    String output= ""+id1;
                    for (int i = 1; i < line1.length; i++) {
                        if(line1[i].equals(line2[i])){
                            output+=";"+line1[i];
                        }else{
                            output+=";"+line1[i]+"-"+line2[i];
                        }
                    }
                    out.println(output);
                    line1=null;
                    line2=null;
                }else if(id1 < id2){
                    String lineOut=line1[0];
                    for (int i = 1; i < line1.length; i++) {
                        lineOut+=line1[i];
                    }
                    out.println(lineOut);
                    line1=null;
                }else{
                    String lineOut=line2[0];
                    for (int i = 1; i < line2.length; i++) {
                        lineOut+=line2[i];
                    }
                    out.println(lineOut);
                    line2=null;
                }
            }

            while(scFile1.hasNextLine()) {
                //copio lo que faltó por revisar
            }

            while(scFile2.hasNextLine()) {
                //copio lo que faltó por revisar
            }
            scFile1.close();
            scFile2.close();
            out.close();


        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        }

    }
}
