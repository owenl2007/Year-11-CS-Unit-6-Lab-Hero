public class Hero {
    String name;
    int hitPoints;

    public Hero (String name){
        this.name = name;
        this.hitPoints = 100;
    }

    public String getName(){
        return name;
    }

    public int getHitPoints(){
        return hitPoints;
    }
    public void attack(Hero opponent) {
        int attackPoint = (int) Math.random();

        if(attackPoint < 0.5){
            opponent.hitPoints -= 10;
        }

        if(attackPoint >= 0.5){
            this.hitPoints -= 10;
        }
    }

    public String toString(){
        return "Hero{name=" + "'" + name + "', " + "hitPoints=" + hitPoints + "}";
    }

    private void fightUntilTheDeathHelper(Hero hero){
        while(this.hitPoints != 0 && hero.hitPoints != 0){
            this.attack(hero);
        }
    }

    public String fightUntilTheDeath(Hero opponent){
        this.senzuBean();
        opponent.senzuBean();
        this.fightUntilTheDeathHelper(opponent);
        return this.name + ": " + this.hitPoints + "       " + opponent.name + ":" + opponent.hitPoints;
    }
    public void senzuBean(){
        this.hitPoints = 100;
    }

    private int nFightsToTheDeathHelper(Hero opponent, int n){
        int wins = 0;
        while (n != 0){
            fightUntilTheDeathHelper(opponent);
            if (this.hitPoints != 0){
                wins += 1;
            }
            this.senzuBean();
            opponent.senzuBean();
            n -= 1;
        }
        return wins;
    }

    public String nFightsToTheDeath(Hero opponent, int n){
        int wins = 0;
        wins = this.nFightsToTheDeathHelper(opponent, n);
        if(n - wins > wins){
            return this.name + ": " + wins + " wins\n" + opponent.name + ": " + (n-wins) + " wins\n" + opponent.name + "wins!";
        }
        else if(n - wins < wins){
            return this.name + ": " + wins + " wins\n" + opponent.name + ": " + (n-wins) + " wins\n" + this.name + "wins!";
        }
        else{
            return this.name + ": " + wins + " wins\n" + opponent.name + ": " + (n-wins) + " wins\n" + "OMG! It was actually a draw!";
        }
    }

    public void dramaticFightToTheDeath(Hero opponent){
        while(this.hitPoints != 0 && opponent.hitPoints != 0){
            this.attack(opponent);
            System.out.println(this.name + ": " + this.hitPoints + "       " + opponent.name + ":" + opponent.hitPoints);
        }

    }

}