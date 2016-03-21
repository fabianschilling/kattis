/**
* @author Fabian Schilling (fabsch@kth.se)
*/

import java.util.*;

public class SetStack {

    static Kattio io = new Kattio(System.in, System.out);

    Stack<HashSet<Object>> stack; // generic stack of sets
    HashMap<HashSet<Object>, Integer> map; // retain size of subsets

    public SetStack() {
        this.stack = new Stack<HashSet<Object>>();
        this.map = new HashMap<HashSet<Object>, Integer>();
    }

    public void push() {
        this.stack.push(new HashSet<Object>());
    }

    public void dup() {
        HashSet<Object> element = this.stack.pop();
        this.stack.push(element);
        this.stack.push(element);
    }

    public void union() {
        HashSet<Object> element1 = this.stack.pop();
        HashSet<Object> element2 = this.stack.pop();
        HashSet<Object> newSet = new HashSet<Object>();
        newSet.addAll(element1);
        newSet.addAll(element2);
        this.stack.push(newSet);
    }

    public void intersect() {
        HashSet<Object> element1 = this.stack.pop();
        HashSet<Object> element2 = this.stack.pop();
        HashSet<Object> newSet = new HashSet<Object>();
        newSet.addAll(element1);
        newSet.retainAll(element2);
        this.stack.push(newSet);
    }

    public void add() {
        HashSet<Object> element1 = this.stack.pop();
        HashSet<Object> element2 = this.stack.pop();
        HashSet<Object> newSet = new HashSet<Object>();
        if (map.containsKey(element1)) {
            newSet.add(map.get(element1));
        } else {
            Integer size = map.size();
            map.put(element1, size);
            newSet.add(size);
        }
        newSet.addAll(element2);
        this.stack.push(newSet);
    }

    public static void main(String[] args) {

        SetStack setstack = new SetStack();

        int t = io.getInt();

        for (int i = 0; i < t; i++) {

            int n = io.getInt();

            for (int j = 0; j < n; j++) {

                char op = io.getWord().charAt(0);

                switch (op) {
                    case 'P': setstack.push(); break;
                    case 'D': setstack.dup(); break;
                    case 'U': setstack.union(); break;
                    case 'I': setstack.intersect(); break;
                    case 'A': setstack.add(); break;
                    default: System.exit(-1);
                }

                io.println(setstack.stack.peek().size());
            }

            io.println("***");
        }

        io.close();

    }
}
