class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length;
        int[] lengWorks = new int[n];

        for (int i = 0; i < n; i++) {
            lengWorks[i] = words[i].length();
        }

        int countWidth = 0;
        List<String> elementResult = new ArrayList<>();
        List<String> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            elementResult.add(words[i]);
            countWidth += lengWorks[i] + 1;

            System.out.println("elementResult " + elementResult);
            System.out.println("countWidth " + countWidth);

            if (i == n - 1) {
                countWidth--;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(elementResult.get(0));
                for (int o = 1; o < elementResult.size(); o++) {
                    stringBuilder.append(" ");
                    stringBuilder.append(elementResult.get(o));
                }
                stringBuilder.append(" ".repeat(maxWidth - countWidth));
                System.out.println("String.valueOf(stringBuilder) " + String.valueOf(stringBuilder).length());
                result.add(String.valueOf(stringBuilder));
            } else if (countWidth + lengWorks[i + 1] > maxWidth) {
                countWidth--;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(elementResult.get(0));

                if (elementResult.size() == 1) {
                    stringBuilder.append(" ".repeat(maxWidth - countWidth));
                } else {
                    int space = (maxWidth - countWidth + elementResult.size() - 1) / (elementResult.size() - 1);
                    int spaceLeft = (maxWidth - countWidth + elementResult.size() - 1) % (elementResult.size() - 1);

                    System.out.println("space " + space);
                    System.out.println("spaceLeft " + spaceLeft);

                    for (int j = 1; j < elementResult.size(); j++) {
                        if (spaceLeft > 0) {
                            stringBuilder.append(" ".repeat(space + 1));
                            spaceLeft--;
                        } else {
                            stringBuilder.append(" ".repeat(Math.max(1, space)));
                        }

                        stringBuilder.append(elementResult.get(j));
                    }
                }

                System.out.println("stringBuilder " + stringBuilder);
                System.out.println("String.valueOf(stringBuilder) " + String.valueOf(stringBuilder).length());
                result.add(String.valueOf(stringBuilder));
                elementResult = new ArrayList<>();
                System.out.println("result " + result);
                countWidth = 0;
            }

        }

        return result;
    }

}