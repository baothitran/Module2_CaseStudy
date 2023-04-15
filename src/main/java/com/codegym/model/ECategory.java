package com.codegym.model;

public enum ECategory {
    BAG(1),SHOES(2),PERFUME(3);

    public int idCategory;

    ECategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }
    public static ECategory findCategoryByID(long id){
        for (ECategory category : ECategory.values()){
            if (category.idCategory==id){
                return category;
            }
        }
        return null;
    }
}
