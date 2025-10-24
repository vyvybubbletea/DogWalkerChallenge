public class DogWalker {
    public int maxDogs;
    public DogWalkCompany company;
    public DogWalker(int max, DogWalkCompany comp){
        maxDogs = max;
        company = comp;
    }
    public int walkdogs(int hour){
        int dogs = company.numAvailableDogs(hour);
        if (dogs < maxDogs){
            company.updateDogs(hour, dogs);
            return dogs;
        }
        else{
            company.updateDogs(hour, maxDogs);
            return maxDogs;
        }
    }
    public int dogWalkShift(int startHour, int endHour){
        int pay = 0;
        while (startHour <= endHour){
            int dogs = walkdogs(startHour);
            pay = pay + dogs * 5;
            if (dogs == maxDogs || startHour >= 9 && startHour <= 17){
                pay = pay + 3;
            }
            startHour = startHour + 1;
        }
        return pay;
    }
}
