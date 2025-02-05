package fr.univlille.iut.infinited.utils;

import fr.univlille.iut.infinited.combat.Combat;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Utils {
    

    public static String readString() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));             
                
        return br.readLine();
    }


    public static void printAnsi(File file) throws IOException {
        
        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            while(br.ready()) {
                System.out.println(br.readLine());
            }

        } 

    }

    public static int readInt(){
        int res = -1;
        try {
            String string = readString();
            res = Integer.parseInt(string);
        } catch (IOException e) {
            System.err.println("Une erreur est survenue lors de la lecture de votre entrée int !");
        } catch (NumberFormatException e){
            System.out.println("Conversion impossible ! Lettre ou autres caractère présents !");
            return readInt();
        }
        return res;
        
    }



    public static final String path =  System.getProperty("user.dir") + File.separator + "res" + File.separator + "history" +  File.separator;
    public static String historyLocation = "combats";


    public static void saveGame(Combat combat) {
        List<Combat> combatsList = Utils.loadGames();
        combatsList.add(combat);

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(path+historyLocation)))) {
            oos.writeObject(combatsList);
        }
        catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde de la game !");
        }

    }   

    
    
    public static Set<String> loadPlayerNames() {
        Set<String> playerNames = new HashSet<String>();
        List<Combat> saveCombats = Utils.loadGames();
        for(Combat c : saveCombats) {
            playerNames.add(c.getPlayer().getName());
        }
        return playerNames;
    } 





    public static List<Combat> loadGames() {


        List<Combat> combats = new ArrayList<Combat>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(path+historyLocation)))) {
           
                combats = (List<Combat>) ois.readObject();
            
        }catch(FileNotFoundException e) {
            File f = new File(path+historyLocation);
            try {
                if(!Files.exists(Paths.get(path))) {
                    Files.createDirectory(Paths.get(path));
                }
                f.createNewFile();
                combats = Utils.loadGames();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }catch(EOFException e) {
            
        }catch(Exception e) {
            System.err.println("Erreur lors du chargement de la sauvegarde de la game !");
        }

        return combats;
    }
} 
