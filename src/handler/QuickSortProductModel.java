package handler;

import model.ProductModel;

import java.util.List;

class QuickSortProductModel {

    static int partition(List<ProductModel> productModelList, int low, int high) {

        ProductModel pivot = productModelList.get(high);

        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (productModelList.get(j).getPrice() <= pivot.getPrice()) {

                i++;

                ProductModel temp = productModelList.get(i);
                productModelList.set(i,productModelList.get(j));
                productModelList.set(j,temp);

            }

        }

        ProductModel temp = productModelList.get(i + 1);
        productModelList.set(i+1,productModelList.get(high));
        productModelList.set(high,temp);

        return (i + 1);
    }

    static void quickSort(List<ProductModel> productModelList, int low, int high) {
        if (low < high) {
            int pi = partition(productModelList, low, high);

            quickSort(productModelList, low, pi - 1);

            quickSort(productModelList, pi + 1, high);
        }
    }
}

