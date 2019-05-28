package potatogame;
import java.util.Scanner;

public class PotatoGame {
    //==================\\
    //==[DECLARATIONS]==\\
    //==================\\
    
    //----/[CLASSES]\----\\
    static Scanner keyboard = new Scanner(System.in);
    
    //----/[PRIMITIVE VARIABLES]\----\\
    static int mainMenuOptions, producerOption;
    public static int potatoes = 0, potatoProduction = 0, potatoesProduced = 0;
    
    
    //==================\\
    //==[SCRIPT LOGIC]==\\
    //==================\\
    
    public static void main(String[] args) {
        Building.Initialize();
        
        //Show the welcome message
        System.out.println("Bem Vindos ao Potato game!");
        System.out.println("");
        
        //Main game
        do{
            System.out.println("|=========[MENU PRINCIPAL]=========|");
            System.out.println("");
            
            switch (mainMenuOptions){
                //Porduce potatoes
                case 0:
                    break;
                case 1:
                    ProducePotatos();
                    System.out.println("");
                    break;
                case 2:
                    ShowCurrentPotatoes();
                    System.out.println("");
                    break;
                case 3:
                    BuyProducers();
                    break;
                case 4:
                    ShowStatus();
                    break;
                default:
                    System.out.println("Não existe essa opção");
                    System.out.println("");
            }
            
            //Show the main menu message
            ShowMainMenuMessage();
            
            //Get the option
            mainMenuOptions = keyboard.nextInt();
            
            //Add a separator
            Separate();
        }while(mainMenuOptions != 0);
        
    }
    
    //=============\\
    //==[METHODS]==\\
    //=============\\
    
    //Show the options
    static void ShowMainMenuMessage(){
        System.out.println("1) Produzir Batatas");
        System.out.println("2) Mostrar quantidade atual de batatas");
        System.out.println("3) Comprar produtores de batatas");
        System.out.println("4) Status");
        System.out.println("0) Sair");
    }
    
    //Show the producer options
    static void ShowProducerOptions(){
        for(int i = 0; i<Building.allBuildings.length;i++){
            Building build = Building.allBuildings[i];
            
            System.out.println((i+1)+") " + build.buildingName + " (" + build.buildingQnt+") | Produção: " + build.potatoProduction + " | Custo: " + build.bPrice + " batatas");
        }
        System.out.println("0) Sair");
    }
    
    //Produces potatos
    static void ProducePotatos(){
        //Create potatos
        potatoes = potatoes + potatoProduction;
        potatoesProduced = potatoesProduced + potatoProduction;
        
        System.out.println("Você produziu "+potatoProduction+" batatas!");
        
        //Tell the player how much potatoes he has
        ShowCurrentPotatoes();
    }
    
    //Tell the player how much potatoes the player has
    static void ShowCurrentPotatoes(){
        System.out.println("Você tem "+potatoes+" batatas!");
    }
    
    //Prints a separator
    static void Separate(){
        for(int clear = 0; clear < 1000; clear++) {
            System.out.println("") ;
        }
    }
    
    //Buy producer
    static void BuyProducers(){
        do{
            //Separate
            Separate();
            
            System.out.println("|=========[COMPRAR PRODUTORES]=========|");
            System.out.println("");
            System.out.println("Batatas: "+potatoes);
            System.out.println("");
            
            //If the 
            if(producerOption>0 && producerOption <= Building.allBuildings.length){
                Building.allBuildings[producerOption-1].PurchaseBuilding();
                System.out.println("");
            }else if(producerOption<0 || producerOption > Building.allBuildings.length){
                System.out.println("Não existe essa opção");
                System.out.println("");
            }
            
            //Show producer options
            ShowProducerOptions();
            
            //Receive input
            producerOption = keyboard.nextInt();
        }while(producerOption != 0);
        
        //Separate
        Separate();
        
        //Create the main menu header
        System.out.println("|=========[MENU PRINCIPAL]=========|");
        System.out.println("");
    }
    
    //Shows the player's status
    static void ShowStatus(){
        System.out.println("Batatas produzidas: "+potatoesProduced+" batatas");
        System.out.println("");
    }
}
