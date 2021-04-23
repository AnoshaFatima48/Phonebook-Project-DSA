import java.util.*;

class TreeNode
{

    HashMap<Character,TreeNode> child;
    boolean isLast;

    public TreeNode()
    {
        child = new HashMap<Character,TreeNode>();


        for (char i = 'a'; i <= 'z'; i++)
            child.put(i,null);

        isLast = false;
    }
}

class Tree
{
    TreeNode root;


    public void insertIntoTree(String contacts[])
    {
        root = new TreeNode();
        int n = contacts.length;
        for (int i = 0; i < n; i++)
        {
            insert(contacts[i]);
        }
    }


    public void insert(String s)
    {
        int len = s.length();


        TreeNode itr = root;
        for (int i = 0; i < len; i++)
        {

            TreeNode nextNode = itr.child.get(s.charAt(i));
            if (nextNode == null)
            {

                nextNode = new TreeNode();

                itr.child.put(s.charAt(i),nextNode);
            }


            itr = nextNode;


            if (i == len - 1)
                itr.isLast = true;
        }
    }


    public void display(TreeNode curNode, String prefix)
    {


        if (curNode.isLast)
            System.out.println(prefix);


        for (char i = 'a'; i <= 'z'; i++)
        {
            TreeNode nextNode = curNode.child.get(i);
            if (nextNode != null)
            {
                display(nextNode, prefix + i);
            }
        }
    }


    void displayContacts(String str)
    {
        TreeNode prevNode = root;
        String prefix = "";
        int len = str.length();
        int i;
        for (i = 0; i < len; i++)
        {
            prefix += str.charAt(i);
            char lastChar = prefix.charAt(i);
            TreeNode curNode = prevNode.child.get(lastChar);

            if (curNode == null)
            {

                i++;
                break;
            }


            if(i==len-1)
            {

            System.out.println("Suggestions based on "+ prefix + " are");
            display(curNode, prefix);}


            prevNode = curNode;
        }

        for ( ; i < len; i++)
        {
            prefix += str.charAt(i);
            if(i==len-1)
            {

            System.out.println("No Results Found for "+ prefix );}
            }
        }
    public void print(Object object[])
    {
        for (int i=0;i<=object.length-1;i++)
        {
            System.out.println(object[i]+"\n");
        }
    }}


   public class Phone_directory
    {

        public static void main(String args[]) {
            Tree phone = new Tree();

            String contacts[] = {"afsa", "aliza", "ilsa", "anusha", "faraz", "palwasha", "usama", "furqan", "saad", "kheemchand", "ibrahim", "fariha", "yaseen", "tabish", "shehzad", "fahad", "sadar", "ashraf", "marya", "faisal khan", "badal", "haris", "noor", "shumaim", "aliraza", "alima", "ritik", "tooba", "saqib", "ahsan", "shahbaz", "faisal khaleel", "sara", "faiz", "amrat", "unza", "muazzam", "kashif"};
            phone.insertIntoTree(contacts);
            System.out.println("Type all to show all contacts!");
            System.out.println("Type search to search a contact!");
            System.out.println("Type insert to search a contact!");
            Scanner input = new Scanner(System.in);
            String opt = input.nextLine();
            if (opt.equals("all") ){
                 phone.print(contacts);
            } else if(opt.equals("search")){
                Scanner contact = new Scanner(System.in);

                System.out.println("type character(s) :");
                String query = contact.nextLine();


                phone.displayContacts(query);
            }
            else if (opt.equals("insert"))
            {
                Scanner insrt = new Scanner (System.in);
                System.out.println("Enter new contact Name: ");
                String newcontact = insrt.nextLine();


                int a;
                contacts = Arrays.copyOf(contacts, contacts.length + 1);


                a = contacts.length;

                contacts[a-1] = newcontact;
                System.out.println("New contact " + newcontact + " inserted succesfully..!");
                System.out.println("Updated:");
                phone.print(contacts);

            }
        }
    }

