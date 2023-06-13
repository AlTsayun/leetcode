public class RomanToInteger_13 {
    public static void main(String[] args) {
        System.out.println(new Solution().romanToInt("III"));
        System.out.println(new Solution().romanToInt("LVIII"));
        System.out.println(new Solution().romanToInt("MCMXCIV"));
    }

    private static class Solution {
        public int romanToInt(String s) {
            int res = 0;
            for (int i = 0; i < s.length(); i++) {
                var c = s.charAt(i);
                switch (c) {
                    case 'I' -> {
                        if (i < s.length() - 1) {
                            var c2 = s.charAt(i + 1);
                            if (c2 == 'X') {
                                res += 9;
                                i++;
                                break;
                            } else if (c2 == 'V'){
                                res+= 4;
                                i++;
                                break;
                            }
                        }
                        res += 1;
                    }
                    case 'V' -> res += 5;
                    case 'X' -> {
                        if (i < s.length() - 1) {
                            var c2 = s.charAt(i + 1);
                            if (c2 == 'C') {
                                res += 90;
                                i++;
                                break;
                            } else if (c2 == 'L'){
                                res+= 40;
                                i++;
                                break;
                            }
                        }
                        res += 10;
                    }
                    case 'L' -> res += 50;
                    case 'C' -> {
                        if (i < s.length() - 1) {
                            var c2 = s.charAt(i + 1);
                            if (c2 == 'M') {
                                res += 900;
                                i++;
                                break;
                            } else if (c2 == 'D'){
                                res+= 400;
                                i++;
                                break;
                            }
                        }
                        res += 100;
                    }
                    case 'D' -> res += 500;
                    case 'M' -> res += 1000;
                    default -> throw new IllegalStateException("Unexpected value: " + c);
                }
            }
            return res;
        }
    }
}
