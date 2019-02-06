import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PizzaCutter
{

    public PizzaCutter()
    {
        // TODO Auto-generated constructor stub
    }

    // tomato 0
    public List<Slice> cut1(Input input)
    {
        // return slices correctly
        // input is the array of 1's and 0's
        // with 1 representing Mushrooms and 0 representing tomatoes
        // testing purposes
        int test = input.getHeightOfPizza();
        int testTwo = input.getLengthofPizza();
        System.out.println("Pizza Height: " + test + " Pizza Length: " + testTwo);

        return null;
    }

    public List<Slice> cut2(Input input)
    {
        int pizza[][] = input.getPizza();
        int pizzaMap[][] = new int[input.getHeightOfPizza()][input.getLengthofPizza()];

        List<Slice> pairs = new ArrayList<Slice>();

        Slice pair;

        for (int col = 0; col < pizza.length; col++)
        {

            for (int row = 0; row < pizza[0].length; row++)
            {
                if (pizzaMap[col][row] != 0)
                    continue;
                int pos = pizza[col][row];
                if (pos == 0)
                {
                    // check right

                    if (row + 1 < pizza[0].length)
                    {
                        if (pizzaMap[col][row + 1] != 0)
                            continue;
                        if (pizza[col][row + 1] == 1)
                        {
                            pair = new Slice(col, row, col, row + 1);
                            markMap(pizzaMap, pair, pairs.size() + 2);
                            pairs.add(pair);
                            continue;
                        }
                    }
                    // check bot

                    if (col + 1 < pizza.length)
                    {
                        if (pizzaMap[col + 1][row] != 0)
                            continue;
                        if (pizza[col + 1][row] == 1)
                        {
                            pair = new Slice(col, row, col + 1, row);
                            markMap(pizzaMap, pair, pairs.size() + 2);
                            pairs.add(pair);
                            continue;

                        }
                    }
                } else
                {
                    // check right

                    if (row + 1 < pizza[0].length)
                    {
                        if (pizzaMap[col][row + 1] != 0)
                            continue;
                        if (pizza[col][row + 1] == 0)
                        {
                            pair = new Slice(col, row, col, row + 1);
                            markMap(pizzaMap, pair, pairs.size() + 2);
                            pairs.add(pair);
                            continue;
                        }
                    }
                    // check bot

                    if (col + 1 < pizza.length)
                    {
                        if (pizzaMap[col + 1][row] != 0)
                            continue;
                        if (pizza[col + 1][row] == 0)
                        {
                            pair = new Slice(col, row, col + 1, row);
                            markMap(pizzaMap, pair, pairs.size() + 2);
                            pairs.add(pair);
                            continue;

                        }
                    }
                }
            }

        }

        printBolMap(pizzaMap);

        int min = input.minIngredients;
        int max = input.getMaxSize();
        List<Slice> smallest = new ArrayList<Slice>();
        List<Slice> minCan = null;
        if (min == 1)
        {
            smallest = pairs;
        } else
        {

            int actual = 2;/// first pair start at 2 because 0 and 1 are used
            // right merge

            Slice rm = null;
            HashMap<Integer, Boolean> usedPairsMap = new HashMap<>();
            int i01 = 2;
            for (Slice s : pairs)
            {
                usedPairsMap.put(i01++, false);
            }

            // get first pair
            for (Integer in : usedPairsMap.keySet())
            {
                actual = in;
                System.out.println("loop " + actual);
                if (usedPairsMap.get(actual))
                    continue;
                Slice mergeRight = pairs.get(actual - 2);

                usedPairsMap.put(actual, true);

                // look for next pair to merge
                for (int col = mergeRight.y1; col < input.getLengthofPizza(); col++)
                {
                    System.out.println(pizzaMap[mergeRight.x1][col]);
                    // pair found
                    if (pizzaMap[mergeRight.x1][col] > actual)
                    {
                        // increase
                        // System.out.println(pairs.get(pizzaMap[first.x1][row] - 2));

                        mergeRight = this.addSlices(mergeRight, pairs.get(pizzaMap[mergeRight.x1][col] - 2));
                        System.out.println("total : "+this.getIngCount(mergeRight, input)+" "+min);
                        if (this.getIngCount(mergeRight, input) >= min)
                        {
                            break;

                        }
                    }
                }
                System.out.println("right " +mergeRight);

                // merge bot
                Slice mergeBot = pairs.get(actual - 2);

                for (int row = mergeRight.x1; row < input.getHeightOfPizza(); row++)
                {
                    System.out.println("row" + pizzaMap[row][mergeBot.y1]);
                    // pair found
                    if (pizzaMap[row][mergeBot.y1] > actual)
                    {
                        mergeBot = addSlices(mergeBot, pairs.get(pizzaMap[row][mergeBot.y1]-2));
                        if (this.getIngCount(mergeRight, input) >= min)
                        {
                            break;

                        }
                    }
                }

                System.out.println("bot " +mergeBot);
                
                // mark map
                this.markMap(pizzaMap, mergeBot, actual, pairs, usedPairsMap);
                printBolMap(pizzaMap);
                for (Boolean bol : usedPairsMap.values())
                {
                    // System.out.println(bol);
                }
                break;
            }
        }
        System.out.println();
        printBolMap(pizzaMap);

        return null;
    }

    private void markMap(int[][] map, Slice slice, int position, List<Slice> pairs,
            HashMap<Integer, Boolean> usedPairsMap)
    {
        for (int col = slice.x1; col <= slice.x2; col++)
        {
            for (int row = slice.y1; row <= slice.y2; row++)
            {
                int toMark = map[col][row];
                if (toMark != 0)
                {
                    Slice t = pairs.get(toMark - 2);
                    usedPairsMap.put(toMark, true);
                    System.out.println(t);
                    map[t.x1][t.y1] = 0;
                    map[t.x2][t.y2] = 0;
                }
                map[col][row] = position;
            }
        }
    }

    private void markMap(int[][] map, Slice slice, int position)
    {
        for (int col = slice.x1; col <= slice.x2; col++)
        {
            for (int row = slice.y1; row <= slice.y2; row++)
            {

                map[col][row] = position;
            }
        }
    }

    private void putUsed(Slice slice, int[][] array, HashMap<Integer, Boolean> isUsedRi)
    {
        for (int col = slice.x1; col <= slice.x2; col++)
        {
            for (int row = slice.y1; row <= slice.y2; row++)
            {

                System.out.println("w dsd " + array[col][row]);
                if (array[col][row] != 0)
                {
                    isUsedRi.put(array[col][row], true);
                }
            }
        }
    }

    private void printBolMap(int[][] map)
    {
        for (int col = 0; col < map.length; col++)
        {
            for (int row = 0; row < map[0].length; row++)
            {
                System.out.printf("%5s ", map[col][row]);
            }
            System.out.println();

        }

    }

    private Slice addSlices(Slice s1, Slice s2)
    {
        int x1, y1, x2, y2;
        x1 = y1 = x2 = y2 = 0;

        x1 = s1.x1 < s2.x1 ? s1.x1 : s2.x1;
        y1 = s1.y1 < s2.y1 ? s1.y1 : s2.y1;

        x2 = s1.x2 > s2.x2 ? s1.x2 : s2.x2;
        y2 = s1.y2 > s2.y2 ? s1.y2 : s2.y2;
        return new Slice(x1, y1, x2, y2);

    }

    private int getCuts(Slice slice)
    {
        return ((slice.x2 - slice.x1) + 1) * ((slice.y2 - slice.y1) + 1);
    }

    private int getIngCount(Slice slice, Input input)
    {
        int count0 = 0, count1 = 0;
        for (int col = slice.x1; col <= slice.x2; col++)
        {
            for (int row = slice.y1; row <= slice.y2; row++)
            {
                if (input.getPizza()[col][row] == 0)
                {
                    count0++;

                } else
                {
                    count1++;
                }

            }
        }
        if (count0 > count1)
            return count1;
        return count0;

    }
}
