package Business.Functions;

import Business.NetworkHelp;
import Business.Enterprises.Enterprise;
import Business.Networks.Network;
import Business.Organizations.DoctorOrg;
import Business.Organizations.HelperOrg;
import Business.Organizations.ManagerOrg;
import Business.Organizations.Org;
import Business.userAccount.Users;

import java.util.Calendar;
import java.util.Date;

public class SysValidations {

    public static boolean StringValidation(String name) {
        return true;
    }

    public static int ageCalculation(Date dateOfBirth) {
        try {
            Calendar dob = Calendar.getInstance();
            dob.setTime(dateOfBirth);
            Calendar today = Calendar.getInstance();
            int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
            if (today.get(Calendar.DAY_OF_YEAR) <= dob.get(Calendar.DAY_OF_YEAR))
                age--;
            return age;
        } catch (Exception e) {
            return 0;
        }
    }

    public static HelperOrg getHelperOrganizations(NetworkHelp environment, Users users) {
        for (Network network : environment.getNetworkList()) {
            if (network.equals(users.getNetwork())) {
                for (Enterprise enterprise : network.getEnterprisesDirectory().getEnterprisesList()) {
                    if (enterprise.getEnterprisesType().equals(Enterprise.EnterprisesType.University)) {
                        for (Org org : enterprise.getOrganizationsDirectory().getOrganizationsList()) {
                            if (org instanceof HelperOrg) {
                                return (HelperOrg) org;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public static HelperOrg getHelperOrganizationsInNw(NetworkHelp environment, Network nw) {
        for (Network network : environment.getNetworkList()) {
            if (network.equals(nw)) {
                for (Enterprise enterprise : network.getEnterprisesDirectory().getEnterprisesList()) {
                    if (enterprise.getEnterprisesType().equals(Enterprise.EnterprisesType.University)) {
                        for (Org org : enterprise.getOrganizationsDirectory().getOrganizationsList()) {
                            if (org instanceof HelperOrg) {
                                return (HelperOrg) org;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public static DoctorOrg getDoctorOrganizations(NetworkHelp environment, Users users) {
        DoctorOrg doctorOrg = null;
        try {
            for (Network network : environment.getNetworkList()) {
                if (network.equals(users.getNetwork())) {
                    for (Enterprise enterprise : network.getEnterprisesDirectory().getEnterprisesList()) {
                        if (enterprise.getEnterprisesType().equals(Enterprise.EnterprisesType.Hospital)) {
                            for (Org org : enterprise.getOrganizationsDirectory().getOrganizationsList()) {
                                if (org instanceof DoctorOrg) {
                                    doctorOrg = (DoctorOrg) org;
                                }
                            }
                        }
                    }
                }
            }
        } catch (NullPointerException npe) {
            npe.printStackTrace();
            return null;
        }
        return doctorOrg;
    }

    public static ManagerOrg getManagerOrganizations(NetworkHelp environment, Users users) {
        ManagerOrg managerOrg = null;
        try {
            for (Network network : environment.getNetworkList()) {
                if (network.equals(users.getNetwork())) {
                    for (Enterprise enterprise : network.getEnterprisesDirectory().getEnterprisesList()) {
                        if (enterprise.getEnterprisesType().equals(Enterprise.EnterprisesType.HealthHub)) {
                            for (Org org : enterprise.getOrganizationsDirectory().getOrganizationsList()) {
                                if (org instanceof ManagerOrg) {
                                    managerOrg = (ManagerOrg) org;
                                }
                            }
                        }
                    }
                }
            }
        } catch (NullPointerException npe) {
            npe.printStackTrace();
            return null;
        }
        return managerOrg;
    }
}
