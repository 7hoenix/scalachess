Chess API written in scala for [lichess.org](https://lichess.org) [![Build Status](https://travis-ci.org/ornicar/scalachess.svg?branch=master)](https://travis-ci.org/ornicar/scalachess)

It is entirely functional, immutable, and free of side effects.

INSTALL
-------

Clone scalachess

    git clone git://github.com/ornicar/scalachess

Get latest sbt on http://www.scala-sbt.org/download.html

Start sbt in scalachess directory

    sbt

In the sbt shell, to compile scalachess, run

    compile

To run the tests (with coverage):

    clean coverage test
    coverageReport

Code formatting
###

This repository uses [scalafmt](https://scalameta.org/scalafmt/).

Please [install it for your code editor](https://scalameta.org/scalafmt/docs/installation.html)
if you're going to contribute to this project.

If you don't install it, please run `scalafmtAll` in the sbt console before committing.


------------------------------------------
Extensions
------------------------------------------

Create a similar function to this `moves` function called `reinforcementMoves` (it shows pieces that are able to move to a particular square on the same team as the piece owner):
https://github.com/7hoenix/scalachess/blob/master/src/main/scala/Actor.scala#L15

Considerations:

- Square ownership matters. E.g. if a monarch is involved then they are only able to reinforce a square that they have ownership of.
- Pawns reinforce only via attacking (diagonals). Although they are able to move to squares which does remove square ownership for open diagonals, ranks, and files that they are now blocking. And also implies gaining square ownership, so if a pawn moves to the square first then that should also be considered when calculating `reinforcementMoves`. -> Use `!` symbol in UI to represent this warning graphicaly.
