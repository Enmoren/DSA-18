/**
 * Solver definition for the 8 Puzzle challenge
 * Construct a tree of board states using A* to find a path to the goal
 */

import java.util.*;

public class Solver {

    public int minMoves = -1;
    private State solutionState;
    private boolean solved = false;

    /**
     * State class to make the cost calculations simple
     * This class holds a board state and all of its attributes
     */
    private class State {
        // Each state needs to keep track of its cost and the previous state
        private Board board;
        private int moves; // equal to g-cost in A*
        public int cost; // equal to f-cost in A*
        private State prev;

        public State(Board board, int moves, State prev) {
            this.board = board;
            this.moves = moves;
            this.prev = prev;
            // TODO
            cost = 0;
        }

        public int totalCost() {
            return this.moves + this.cost;
        }

        @Override
        public boolean equals(Object s) {
            if (s == this) return true;
            if (s == null) return false;
            if (!(s instanceof State)) return false;
            return ((State) s).board.equals(this.board);
        }
    }

    /*
     * Return the root state of a given state
     */
    private State root(State state) {
        // TODO: Your code here
        return null;
    }

    private Iterable<State> neighbors(State q) {
        Iterable<Board> boards = q.board.neighbors();
        List<State> states = new LinkedList<>();
        for (Board board: boards) {
            State u = new State(board, q.moves + 1, q);
            u.cost = u.board.manhattan();
            states.add(u);
        }
        return states;
    }

    /*
     * A* Solver
     * Find a solution to the initial board using A* to generate the state tree
     * and a identify the shortest path to the the goal state
     */
    public Solver(Board initial) {
        // TODO: Your code here
        Queue<State> open = new PriorityQueue<>(5, (a,b) -> a.totalCost() - b.totalCost());
        List<State> closed = new LinkedList<>();
        open.add(new State(initial, 0, null));

        while (open.peek() != null) {
            State q = open.poll();
            Iterable<State> successors = neighbors(q);

            for (State u: successors) {
                if (u.board.isGoal()) {
                    //TODO: figure out stop search
                    break;
                }

                // check if u is in open, and has less cost1

                // check if u is in closed, and has less cost

            }
        }

        //// A*
        //open = [ ]
        //closed = [ ]
        //open.add(START); START.f = 0
        //
        //while (!open.isEmpty()) {
        //    q = open.pop(node with smallest f)
        //
        //    for each successor u of q {
        //        if u is GOAL: stop search
        //
        //        u.g = q.g + distance(q, u)
        //        u.h = heuristic_distance(u, GOAL)
        //        u.f = u.g + u.h
        //
        //        for n in open:
        //             if (n.equals(u) && n.f < u.f) ignore u
        //        for n in closed:
        //             if (n.equals(u) && n.f < u.f) ignore u
        //
        //        If u not ignored:
        //open.add(u)
        //       	u.parent = q
        //
        //    } // for
        //
        //    closed.add(q)
        //} // while
    }

    /*
     * Is the input board a solvable state
     * Research how to check this without exploring all states
     */
    public boolean isSolvable() {
        // TODO: Your code here
        return false;
    }

    /*
     * Return the sequence of boards in a shortest solution, null if unsolvable
     */
    public Iterable<Board> solution() {
        // TODO: Your code here
        return null;
    }

    public State find(Iterable<State> iter, Board b) {
        for (State s : iter) {
            if (s.board.equals(b)) {
                return s;
            }
        }
        return null;
    }

    /*
     * Debugging space
     */
    public static void main(String[] args) {
        int[][] initState = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        Board initial = new Board(initState);

        Solver solver = new Solver(initial);
    }


}
