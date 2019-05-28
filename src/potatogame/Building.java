package potatogame;

public class Building {
    public static Building[] allBuildings = new Building[2];
    
    public String buildingName;
    public int bPrice, bAdditionalPrice, bAdditionalPricePerPurchase, potatoProduction, buildingQnt = 0;
    
    //Initialize the class
    public static void Initialize(){
        //Create buildings and store them in the allBuildings table
        CreateBuilding(0, "Fazenda", 0, 1, 2, 20);
        CreateBuilding(1, "Fabrica", 20000, 400, 1000, 4000);
    }
    
    //Purchases this building
    public void PurchaseBuilding(){
        if(PotatoGame.potatoes >= bPrice){
            PotatoGame.potatoes -= bPrice;
            
            bPrice += bAdditionalPrice;
            bAdditionalPrice += bAdditionalPricePerPurchase;
            buildingQnt ++;
            PotatoGame.potatoProduction += potatoProduction;
            
            System.out.println("Comprado 1 "+buildingName+" com sucesso!");
        }else{
            System.out.println("Você não tem batatas suficientes!");
        }
    }
    
    //Creates a building
    private static void CreateBuilding(int index,String name, int price, int addPrice, int addPricePPurchase, int prod){
        
        //Create the class
        allBuildings[index] = new Building();
        
        //Assign properties
        allBuildings[index].buildingName = name;
        allBuildings[index].bPrice = price;
        allBuildings[index].bAdditionalPrice = addPrice;
        allBuildings[index].bAdditionalPricePerPurchase = addPricePPurchase;
        allBuildings[index].potatoProduction = prod;
    }
}
