package com.imooc.dao;

/**
 * @author yugi
 * @apiNote
 * @since 2017-07-05
 */
public class CustomerContextHolder {

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public static void setCustomerType(String customerType) {
        contextHolder.set(customerType);
    }

    public static String getCustomerType() {
        return contextHolder.get();
    }

    public static void clearCustomerType() {
        contextHolder.remove();
    }
}