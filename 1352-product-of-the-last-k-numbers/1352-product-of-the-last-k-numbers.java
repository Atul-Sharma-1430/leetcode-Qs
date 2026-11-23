class ProductOfNumbers {
    List<Long> listProduct;

    public ProductOfNumbers() {
        listProduct = new ArrayList<>();
        listProduct.add(1L);
    }

    public void add(int num) {
        if (num == 0) {
            listProduct = new ArrayList<>();
            listProduct.add(1L);
        } else {
            long product = listProduct.get(listProduct.size() - 1) * num;
            listProduct.add(product);
        }
    }

    public int getProduct(int k) {
        if (k >= listProduct.size()) {
            return 0;
        }

        long ans = listProduct.get(listProduct.size() - 1) / listProduct.get(listProduct.size() - 1 - k);

        return (int) ans;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */