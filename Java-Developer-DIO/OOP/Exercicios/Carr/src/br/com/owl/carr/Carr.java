package br.com.owl.carr;

public class Carr {
    private int maxPeople ;
    private int qtdPeople;
    private boolean openDoor;

    public Carr(int maxPeople)
    {
        this.maxPeople = maxPeople;
    }

    public int getMaxPeople()
    {
        return this.maxPeople;
    }

    public int getQtdPeople()
    {
        return this.qtdPeople;
    }
    public void setQtdPeople(int qtdPeople)
    {
        this.qtdPeople = qtdPeople;
    }

    public void peopleEnter()
    {
        if (this.openDoor && this.qtdPeople < this.maxPeople)
        {
            System.out.println("The door is open, we still have accents you can enter.");
            this.qtdPeople++;
        }
        else if (this.openDoor == false && this.qtdPeople < this.maxPeople)
        {
            System.out.println("Sorry the door is closed, but we still have vacancies. I will open it for you to enter.");
            this.openDoor = true;
            this.qtdPeople++;
        }
        else if (this.qtdPeople >= this.maxPeople)
        {
            System.out.println("Sorry we have no more vacancies.");
            if (this.openDoor)
            {
                System.out.println("Clack!");
                this.openDoor = false;
            }
        }
    }

    public void peopleExit()
    {
        if (this.openDoor && this.qtdPeople > 0)
        {
            this.qtdPeople--;
        }
        else if (this.openDoor == false && this.qtdPeople > 0)
        {
            this.openDoor = true;
            this.qtdPeople--;
            this.openDoor = false;
        }
    }
}
