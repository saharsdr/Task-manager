import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ReadWriteIO {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\sahar\\Documents\\code\\tasks.txt";
//         **************************
//         **************************

//        try(FileWriter writer = new FileWriter(filePath)){
//            writer.write("salam! donya!");
//        } catch (IOException e) {
//            throw new RuntimeException(e.getMessage());
//        }


//         *****************************
//         *****************************

//        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
//            String line;
//            while ((line = reader.readLine()) != null){
//                System.out.println(line);
//            }
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }

//         *****************************
//         *****************************

//        try(FileWriter writer = new FileWriter(filePath, true)){
//            writer.write("\nHello my Friend!");
//            writer.write("\nHello my Friend!");
//            writer.write("\nHello my Friend!");
//            writer.write("\nHello my Friend!");
//        } catch(IOException e){
//            System.out.println(e.getMessage());
//        }

//         *****************************
//         *****************************

//        List<String> lines = Arrays.asList("خط اول", "خط دوم", "خط سوم");
//        try(FileWriter writer = new FileWriter(filePath, true)){
//            for(String line : lines){
//                writer.write(line);
//                writer.write("\n");
//            }
//        }catch (IOException e){
//            System.out.println(e.getMessage());
//        }

//        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
//            String line;
//            while((line = reader.readLine()) != null){
//                System.out.println(line);
//            }
//        }catch(IOException e){
//            System.out.println(e.getMessage());
//        }
//

    }
}
