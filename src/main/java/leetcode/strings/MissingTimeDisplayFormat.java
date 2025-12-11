package leetcode.strings;

public class MissingTimeDisplayFormat {
    public static void main(String[] args) {
        String str = "@2:45:00";
        System.out.println(findTheMissingTimeFromTheGivenString(str));
        str = "10:@6:00";
        System.out.println(findTheMissingTimeFromTheGivenString(str));
        str = "10:@7:00";
        System.out.println(findTheMissingTimeFromTheGivenString(str));
    }

    private static String findTheMissingTimeFromTheGivenString(String str) {

        String[] timeArray = str.split(":");
        StringBuilder minimumTime = new StringBuilder();
        StringBuilder maxTime = new StringBuilder();
        for (int i=0; i<timeArray.length; i++) {
            String index = timeArray[i];
            int indexPoint = index.indexOf("@");
            if (indexPoint == 0) {
                String minStr = index.replace("@", "0");
                String maxStr;
                if (i==0) {
                    maxStr = index.replace("@", "2");
                } else {
                    maxStr = index.replace("@", "5");
                }
                minimumTime.append(minStr).append(":");
                maxTime.append(maxStr).append(":");
            } else if (indexPoint == 1) {
                String minStr = index.replace("@", "0");
                String maxStr;
                if (i==0) {
                    maxStr = index.replace("@", "3");
                } else {
                    maxStr = index.replace("@", "9");
                }
                minimumTime.append(minStr).append(":");
                maxTime.append(maxStr).append(":");
            } else {
                minimumTime.append(index);
                maxTime.append(index);
            }
        }

        return "Minimum Time " + minimumTime.toString() + " Maximum Time " + maxTime.toString();
    }
}

