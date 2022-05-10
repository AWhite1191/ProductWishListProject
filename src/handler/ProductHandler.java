package handler;

import model.ProductModel;

import java.util.ArrayList;
import java.util.List;

public class ProductHandler {

    private static CustomArrayList<ProductModel> customArrayList = new CustomArrayList();
    private static BTree bTree = new BTree(3);

    public static void addProduct(ProductModel productModel){
        customArrayList.add(productModel);

        bTree.Insert(productModel);
    }


    public static void updateProduct(ProductModel productModel){
        for(int x = 0; x< customArrayList.size; x++){
            ProductModel pModel = customArrayList.get(x);

            if (pModel.getId() == productModel.getId()) {
                customArrayList.set(x,productModel);
            }
        }
    }

    public static void deleteProduct(ProductModel productModel){
        int selProductIndex = -1;
        for(int x = 0; x< customArrayList.size; x++){
            ProductModel pModel = customArrayList.get(x);
            if(pModel.getId() == productModel.getId()){
                selProductIndex = x;
            }
        }

        customArrayList.remove(selProductIndex);
    }

    public static ProductModel getProductModel(String productId){

        ProductModel returnModel=null;
        for(int x = 0; x< customArrayList.size; x++){
            ProductModel productModel = customArrayList.get(x);
            if(productModel.getId() == Integer.parseInt(productId)){
                returnModel = productModel;
            }
        }
        return returnModel;
    }

    //to return sorted products based on price
    public static List<ProductModel> getProductModelList() {

        int size = customArrayList.size;

        List<ProductModel> productModelList = new ArrayList<>();
        for(int x=0;x<size;x++){
            productModelList.add(customArrayList.get(x));
        }
        QuickSortProductModel.quickSort(productModelList, 0, size - 1);
        return productModelList;
    }


}
