class Main 
{
  static int index = 0;

  public static void main(String[] args) 
  {
    System.out.println("Program Start");

    String input = "{{1,2},3}";
    input = ToBasics(input);
    System.out.println("User Input:" + input);

    if(Set(input))
    {
      System.out.println("Valid");
    }
    else
    {
      System.out.println("Invalid");
    }
  }

  static String ToBasics(String input)
  {
    return input.replaceAll("\\d", "n");
  }

  static boolean ValidateCharacter(char character, String input)
  {
    System.out.println("ValidateCharacter [" + character + "][" + index + "][" + input.charAt(index)+"]");
    if(character == input.charAt(index))
    {
      index++;
      return true;
    }
    return false;
  }

  static boolean Set(String input)
  {
    System.out.println("Set [" + index + "][" + input.charAt(index)+"]");
    if ( ValidateCharacter('{', input)
      && List(input)
      && ValidateCharacter('}', input))
    {
      return true;
    }
    return false;
  }

  static boolean List(String input)
  {
    System.out.println("List [" + index + "][" + input.charAt(index)+"]");
    if(Head(input) && Tail(input))
    {
      return true;
    }
    return true;
  }

  static boolean Head(String input)
  {
    System.out.println("Head [" + index + "][" + input.charAt(index)+"]");
    if(ValidateCharacter('n', input))
    {
      index++;
      return true;
    }
    else if(Set(input))
    {
      return true;
    }
    return false;
  }

  static boolean Tail(String input)
  {
    System.out.println("Tail [" + index + "][" + input.charAt(index)+"]");
    if ( ValidateCharacter(',', input)
      && Head(input)
      && Tail(input))
    {
      index++;
      return true;
    }
    return true;
  }
}