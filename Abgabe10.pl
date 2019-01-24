istUnterkunft(wh).
istUnterkunft(bh).
istUnterkunft(sh).
istUnterkunft(ph).
istUnterkunft(jh).
istUnterkunft(fb).

hatEinenStern(ph).
hatZweiSterne(sh).
hatDreiSterne(jh).
hatVierSterne(wh).
hatFuenfSterne(bh).
hatFuenfSterne(fb).

/*?- hatFuenfSterne(X).
*X = bh ;
*X = fb.
*/

hatEinenSternWeniger(U1,U2):- (hatEinenStern(U1),hatZweiSterne(U2)).
hatEinenSternWeniger(U1,U2):- (hatZweiSterne(U1),hatDreiSterne(U2)).
hatEinenSternWeniger(U1,U2):- (hatDreiSterne(U1),hatVierSterne(U2)).
hatEinenSternWeniger(U1,U2):- (hatVierSterne(U1),hatFuenfSterne(U2)).

/*?- istUnterkunft(U), hatEinenSternWeniger(X, U).
*U = wh,
*X = jh ;
*U = bh,
*X = wh ;
*U = sh,
*X = ph ;
*U = jh,
*X = sh ;
*U = fb,
*X = wh.
*/

hatWenigerSterne(X,Y):-hatEinenSternWeniger(X, Y).
hatWenigerSterne(X,Y):-hatEinenSternWeniger(X,Z),hatWenigerSterne(Z,Y).


%4
isList(nil).
isList(cons(_,X)):-isList(X).

toPrologList(cons(Z,nil),[A|[]]):- isList(cons(Z,nil)), A==Z.
toPrologList(cons(Z,X),[A|Y]):- isList(cons(Z,X)),A==Z,toPrologList(X,Y).

flatten([[]],[]).
flatten([[]|Y],R):- flatten(Y,R).
flatten([X|Z],[A|R]):- A==X, flatten(Z,R).
flatten([[X|Y]|Z], [A|R]):- X==A, flatten([Y|Z],R).

appendElement([],Y,Z):- [Y]==Z.
appendElement([X|R],Y,[Z|A]):- X==Z,appendElement(R,Y,A).

reverseList(Xs, Ys) :- reverseList(Xs, [], Ys, Ys).
reverseList([], Ys, Ys, []).
reverseList([X|Xs], Rs, Ys, [_|Bound]) :- reverseList(Xs, [X|Rs], Ys, Bound).
