
package vn.aptech.quanlybanhang.common;

import java.text.NumberFormat;
import java.util.Locale;

import vn.aptech.quanlybanhang.utilities.I18n;
import vn.aptech.quanlybanhang.entities.Department;


public class StringCommon {

    private static final Locale localeVN = new Locale("vi", "VN");

    public static boolean isNullOrBlank(String str) {
        return str == null || str.trim().equals("");
    }

    public static String convertDoubleToVND(double input) {
        return NumberFormat.getCurrencyInstance(localeVN).format(input);
    }

    public static String formatNumberCommas(int num) {
        return String.format("%,d", num);
    }

    public static String safeNullObject(String str) {
        if (isNullOrBlank(str)) {
            return "-";
        }
        return str;
    }

    public static String getDepartmentString(Department department) {
        switch (department.name()) {
            case "ROLE_ADMIN":
                return I18n.getMessage("role.employee.administrator");
            case "ROLE_EMPLOYEE_CASHER":
                return I18n.getMessage("role.employee.cashier");
            case "ROLE_EMPLOYEE_INVENTORY":
                return I18n.getMessage("role.employee.inventory");
            default:
                return I18n.getMessage("role.employee.unknown");
        }
    }
}
