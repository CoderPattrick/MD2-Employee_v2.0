package storage.IOManager;

import model.employee.Employee;

import java.io.*;
import java.util.ArrayList;

public class IOManager {
    public static IOManager IOtool = new IOManager();
    public static ArrayList<Employee> savedList = IOtool.readFile();
    public static final String SAVE_PATH = "src\\storage\\savePath\\employeeList.dat";



    public ArrayList<Employee> readFile(){
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(SAVE_PATH);
        } catch (FileNotFoundException e) {
            System.err.println("File not found!");
            return new ArrayList<>();
        }
        try {
            ObjectInputStream reader = new ObjectInputStream(fis);
            ArrayList<Employee> list = (ArrayList<Employee>)reader.readObject();
            reader.close();
            fis.close();
            return list;
        } catch (IOException e) {
            System.err.println("Something wrong, cant read file!");
        } catch (ClassNotFoundException e) {
            System.err.println("Type of data in file is invalid, cant read!");;
        }
        return new ArrayList<>();
    }
    public void writeFile(ArrayList<Employee> list){
        FileOutputStream fos ;
        ObjectOutputStream writer ;
        try {
            fos = new FileOutputStream(SAVE_PATH);
        } catch (FileNotFoundException e) {
            System.err.println("File not found, created new one!");
            writeFile(list);
            return;
        }
        try {
            writer = new ObjectOutputStream(fos);
            writer.writeObject(list);
            writer.close();
            fos.close();
        } catch (IOException e) {
            System.err.println("Something wrong, cant write file!");
        }
    }
}
