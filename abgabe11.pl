divisors(X, Y) :- dv(X,1,Y).

dv(X,X,[X]).
dv(X,B,[B|Tail]) :- X > B,0 is X mod B, Bnew is B+1, dv(X,Bnew,Tail).
dv(X,B,Y) :- X > B,not(0 is X mod B), Bnew is B+1, dv(X,Bnew,Y).
