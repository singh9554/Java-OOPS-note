Complete Java String Methods Reference
1. STRING CREATION & BASIC INFO
   String Creation Methods
   javaString str1 = "Hello";           // String literal
   String str2 = new String("Hello"); // Using constructor
   String str3 = String.valueOf(123); // From other data types
   String str4 = String.copyValueOf(charArray); // From char array
   Basic Information Methods
   MethodReturn TypeDescriptionExamplelength()intReturns string length"Hello".length() → 5isEmpty()booleanChecks if string is empty"".isEmpty() → trueisBlank()booleanChecks if string is blank/whitespace only (Java 11+)"  ".isBlank() → true

2. CHARACTER ACCESS & MANIPULATION
   Character Access
   MethodReturn TypeDescriptionExamplecharAt(int index)charReturns character at index"Hello".charAt(1) → 'e'codePointAt(int index)intReturns Unicode code point"Hello".codePointAt(0) → 72codePointBefore(int index)intReturns code point before index"Hello".codePointBefore(1) → 72codePointCount(int begin, int end)intCount of code points in range"Hello".codePointCount(0, 5) → 5
   Character Array Conversion
   MethodReturn TypeDescriptionExampletoCharArray()char[]Converts to character array"Hello".toCharArray() → ['H','e','l','l','o']getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)voidCopies chars to array-

3. SUBSTRING & EXTRACTION
   MethodReturn TypeDescriptionExamplesubstring(int beginIndex)StringSubstring from index to end"Hello".substring(2) → "llo"substring(int beginIndex, int endIndex)StringSubstring between indices"Hello".substring(1, 4) → "ell"subSequence(int beginIndex, int endIndex)CharSequenceReturns subsequence"Hello".subSequence(1, 4) → "ell"

4. SEARCH & INDEX OPERATIONS
   Finding Characters/Strings
   MethodReturn TypeDescriptionExampleindexOf(int ch)intFirst occurrence of character"Hello".indexOf('l') → 2indexOf(int ch, int fromIndex)intFirst occurrence from index"Hello".indexOf('l', 3) → 3indexOf(String str)intFirst occurrence of substring"Hello World".indexOf("World") → 6indexOf(String str, int fromIndex)intFirst occurrence from index"Hello Hello".indexOf("Hello", 1) → 6lastIndexOf(int ch)intLast occurrence of character"Hello".lastIndexOf('l') → 3lastIndexOf(int ch, int fromIndex)intLast occurrence before index"Hello".lastIndexOf('l', 2) → 2lastIndexOf(String str)intLast occurrence of substring"Hello Hello".lastIndexOf("Hello") → 6lastIndexOf(String str, int fromIndex)intLast occurrence before index-
   Checking Content
   MethodReturn TypeDescriptionExamplecontains(CharSequence s)booleanChecks if contains sequence"Hello".contains("ell") → truestartsWith(String prefix)booleanChecks if starts with prefix"Hello".startsWith("He") → truestartsWith(String prefix, int offset)booleanChecks prefix from offset"Hello".startsWith("ll", 2) → trueendsWith(String suffix)booleanChecks if ends with suffix"Hello".endsWith("lo") → true

5. COMPARISON METHODS
   Basic Comparison
   MethodReturn TypeDescriptionExampleequals(Object obj)booleanChecks exact equality"Hello".equals("Hello") → trueequalsIgnoreCase(String str)booleanChecks equality ignoring case"Hello".equalsIgnoreCase("HELLO") → truecompareTo(String str)intLexicographic comparison"apple".compareTo("banana") → -1compareToIgnoreCase(String str)intCase-insensitive comparison"Apple".compareToIgnoreCase("apple") → 0
   Pattern Matching
   MethodReturn TypeDescriptionExamplematches(String regex)booleanMatches regular expression"123".matches("\\d+") → trueregionMatches(int toffset, String other, int ooffset, int len)booleanMatches region-regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len)booleanMatches region with case option-

6. CASE CONVERSION
   MethodReturn TypeDescriptionExampletoLowerCase()StringConverts to lowercase"HELLO".toLowerCase() → "hello"toLowerCase(Locale locale)StringConverts to lowercase with locale"HELLO".toLowerCase(Locale.ENGLISH)toUpperCase()StringConverts to uppercase"hello".toUpperCase() → "HELLO"toUpperCase(Locale locale)StringConverts to uppercase with locale"hello".toUpperCase(Locale.ENGLISH)

7. WHITESPACE & TRIMMING
   MethodReturn TypeDescriptionExampletrim()StringRemoves leading/trailing whitespace"  Hello  ".trim() → "Hello"strip()StringRemoves leading/trailing whitespace (Java 11+)"  Hello  ".strip() → "Hello"stripLeading()StringRemoves leading whitespace (Java 11+)"  Hello  ".stripLeading() → "Hello  "stripTrailing()StringRemoves trailing whitespace (Java 11+)"  Hello  ".stripTrailing() → "  Hello"

8. REPLACEMENT & MODIFICATION
   Character/String Replacement
   MethodReturn TypeDescriptionExamplereplace(char oldChar, char newChar)StringReplaces all occurrences of character"Hello".replace('l', 'x') → "Hexxo"replace(CharSequence target, CharSequence replacement)StringReplaces all occurrences of sequence"Hello World".replace("World", "Java") → "Hello Java"replaceAll(String regex, String replacement)StringReplaces using regex"Hello123World456".replaceAll("\\d+", "") → "HelloWorld"replaceFirst(String regex, String replacement)StringReplaces first match using regex"Hello123World456".replaceFirst("\\d+", "") → "HelloWorld456"

9. SPLITTING & JOINING
   Splitting
   MethodReturn TypeDescriptionExamplesplit(String regex)String[]Splits by regex"a,b,c".split(",") → ["a", "b", "c"]split(String regex, int limit)String[]Splits by regex with limit"a,b,c,d".split(",", 2) → ["a", "b,c,d"]
   Joining (Static Methods)
   MethodReturn TypeDescriptionExampleString.join(CharSequence delimiter, CharSequence... elements)StringJoins elements with delimiterString.join(",", "a", "b", "c") → "a,b,c"String.join(CharSequence delimiter, Iterable<? extends CharSequence> elements)StringJoins iterable with delimiterString.join(",", Arrays.asList("a", "b")) → "a,b"

10. FORMATTING METHODS
    MethodReturn TypeDescriptionExampleString.format(String format, Object... args)StringFormatted stringString.format("Hello %s", "World") → "Hello World"String.format(Locale l, String format, Object... args)StringFormatted with locale-formatted(Object... args)StringInstance formatting (Java 15+)"Hello %s".formatted("World") → "Hello World"

11. CONVERSION METHODS
    To String (Static Methods)
    MethodReturn TypeDescriptionExampleString.valueOf(boolean b)StringBoolean to stringString.valueOf(true) → "true"String.valueOf(char c)StringChar to stringString.valueOf('A') → "A"String.valueOf(char[] data)StringChar array to stringString.valueOf(new char[]{'a','b'}) → "ab"String.valueOf(char[] data, int offset, int count)StringChar array subset to string-String.valueOf(double d)StringDouble to stringString.valueOf(3.14) → "3.14"String.valueOf(float f)StringFloat to stringString.valueOf(3.14f) → "3.14"String.valueOf(int i)StringInt to stringString.valueOf(123) → "123"String.valueOf(long l)StringLong to stringString.valueOf(123L) → "123"String.valueOf(Object obj)StringObject to stringString.valueOf(obj) → obj.toString()
    From String
    MethodReturn TypeDescriptionExampletoString()StringReturns string representationstr.toString() → str

12. REPEAT & LINES (JAVA 11+)
    MethodReturn TypeDescriptionExamplerepeat(int count)StringRepeats string n times"Hi".repeat(3) → "HiHiHi"lines()Stream<String>Stream of lines"a\nb\nc".lines().count() → 3

13. INDENTATION (JAVA 12+)
    MethodReturn TypeDescriptionExampleindent(int n)StringAdjusts indentation"Hello".indent(2) → "  Hello\n"

14. TRANSFORMATION (JAVA 12+)
    MethodReturn TypeDescriptionExampletransform(Function<? super String, ? extends R> f)RApplies function to string"hello".transform(String::toUpperCase) → "HELLO"

15. INTERN & MEMORY
    MethodReturn TypeDescriptionExampleintern()StringReturns canonical representationnew String("Hello").intern()

16. HASH CODE & EQUALS
    MethodReturn TypeDescriptionExamplehashCode()intReturns hash code"Hello".hashCode()equals(Object obj)booleanChecks equality"Hello".equals("Hello") → true

17. PRACTICAL EXAMPLES BY CATEGORY
    String Analysis
    javaString text = "Hello World";
    System.out.println("Length: " + text.length());           // 11
    System.out.println("Empty: " + text.isEmpty());           // false
    System.out.println("Contains 'World': " + text.contains("World")); // true
    System.out.println("Starts with 'Hello': " + text.startsWith("Hello")); // true
    System.out.println("Ends with 'World': " + text.endsWith("World"));     // true
    String Manipulation
    javaString original = "  Hello World  ";
    System.out.println("Trimmed: '" + original.trim() + "'");              // "Hello World"
    System.out.println("Uppercase: " + original.toUpperCase());            // "  HELLO WORLD  "
    System.out.println("Replace: " + original.replace("World", "Java"));   // "  Hello Java  "
    System.out.println("Substring: " + original.substring(2, 7));          // "Hello"
    String Searching
    javaString text = "Java is awesome, Java is powerful";
    System.out.println("First 'Java': " + text.indexOf("Java"));           // 0
    System.out.println("Last 'Java': " + text.lastIndexOf("Java"));        // 17
    System.out.println("'is' at position: " + text.indexOf("is"));         // 5
    System.out.println("Character 'a' first at: " + text.indexOf('a'));    // 1
    String Splitting and Joining
    javaString csv = "apple,banana,orange";
    String[] fruits = csv.split(",");                    // ["apple", "banana", "orange"]
    String joined = String.join(" | ", fruits);          // "apple | banana | orange"
    Regular Expression Operations
    javaString text = "abc123def456";
    System.out.println("Contains digits: " + text.matches(".*\\d.*"));      // true
    String noDigits = text.replaceAll("\\d+", "");                         // "abcdef"
    String onlyDigits = text.replaceAll("[^\\d]", "");                     // "123456"

18. PERFORMANCE NOTES
    Immutable Nature

Strings are immutable - every operation creates a new String object
For multiple operations, consider StringBuilder or StringBuffer

Memory Considerations

Use intern() carefully - it stores strings in string pool
String literals are automatically interned
new String() creates objects in heap, not string pool

Best Practices

Use equals() for content comparison, not ==
Use StringBuilder for concatenation in loops
Use String.join() instead of manual concatenation
Consider String.format() or formatted() for complex formatting

This comprehensive reference covers all major String methods available in Java, organized for quick lookup and understanding!