public class Program {
    static class CharacterPatternMap {
        private Character character;
        private String[] pattern;
        public CharacterPatternMap(Character character, String[] pattern) {
            this.character = character;
            this.pattern = pattern;
        }
        public Character getCharacter() {
            return character;
        }
        public String[] getPattern() {
            return pattern;
        }
    }
    public static CharacterPatternMap[] createCharacterPatternMaps() {
        String[] OPattern = {
                "*****",
                "*   *",
                "*   *",
                "*   *",
                "*****"
        };
        String[] PPattern = {
                "*****",
                "*   *",
                "*****",
                "*    ",
                "*    "
        };
        String[] SPattern = {
                "******",
                "*     ",
                "******",
                "     *",
                "******"
        };
        String[] spacePattern = {
                "     ",
                "     ",
                "     ",
                "     ",
                "     "
        };
        return new CharacterPatternMap[] {
                new CharacterPatternMap('O', OPattern),
                new CharacterPatternMap('P', PPattern),
                new CharacterPatternMap('S', SPattern),
                new CharacterPatternMap(' ', spacePattern)
        };
    }
    public static String[] getCharacterPattern(char ch, CharacterPatternMap[] charMaps) {
        for (CharacterPatternMap map : charMaps) {
            if (map.getCharacter() == ch) {
                return map.getPattern();
            }
        }
        return getCharacterPattern(' ', charMaps);
    }
    public static void printMessage(String message, CharacterPatternMap[] charMaps) {
        int rows = 5;
        for (int i = 0; i < rows; i++) {
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < message.length(); j++) {
                char ch = message.charAt(j);
                String[] pattern = getCharacterPattern(ch, charMaps);
                line.append(pattern[i]).append("  ");
            }
            System.out.println(line);
        }
    }
    public static void main(String[] args) {
        CharacterPatternMap[] charMaps = createCharacterPatternMaps();
        String message = "OOPS";
        printMessage(message, charMaps);
    }
}