class Main 
{
  public static void main(String[] args) 
  {
    System.out.println("Program Start");

    String input = "{{1,2},3}";
    input = ToBasics(input);
    System.out.println("User Input:" + input);

    if(Set(input, 0))
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

  static boolean ValidateCharacter(char character, String input, int index)
  {
    System.out.println("ValidateCharacter [" + character + "][" + index + "][" + input.charAt(index)+"]");
    if(character == input.charAt(index))
    {
      return true;
    }
    return false;
  }

  static boolean Set(String input, int index)
  {
    System.out.println("Set [" + index + "][" + input.charAt(index)+"]");
    if ( ValidateCharacter('{', input, index)
      && List(input, index+1)
      && ValidateCharacter('}', input, index+2))
    {
      return true;
    }
    return false;
  }

  static boolean List(String input, int index)
  {
    System.out.println("List [" + index + "][" + input.charAt(index)+"]");
    if(Head(input, index) && Tail(input, index+1))
    {
      return true;
    }
    return true;
  }

  static boolean Head(String input, int index)
  {
    System.out.println("Head [" + index + "][" + input.charAt(index)+"]");
    if(ValidateCharacter('n', input, index))
    {
      return true;
    }
    else if(Set(input, index))
    {
      return true;
    }
    return false;
  }

  static boolean Tail(String input, int index)
  {
    System.out.println("Tail [" + index + "][" + input.charAt(index)+"]");
    if ( ValidateCharacter(',', input, index)
      && Head(input, index+1)
      && Tail(input, index+2))
    {
      return true;
    }
    return true;
  }
}