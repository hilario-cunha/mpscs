# Inspiration for the Structure Aspect

Here we discuss which resources we used in order to design the C# base language well and to ensure
that the structure satisfies all promised features. We also present other possible resources that
could have been used for this purpose and the reasons why we did not use them.

The main resource that we used to design the language structure was the freely-available grammar
of C# 5.0. We transformed a lot of the grammar symbols into MPS Structure concepts almost
one-to-one. The other grammar symbols were either too low-level and the MPS supports them
automatically, or were skipped as we do not support the corresponding features, or were designed
differently. On the contrary, some concepts are not in the grammar as well as those features were
designed purely for purposes of fitting the language into MPS.

A lot of inspiration also came from the solutions used in the Base Language (i.e. the Java base
language). However, it has no documentation and some of its parts are deprecated - thus, in many
cases, it is not a good resource of inspiration as one is not able to figure out exactly the idea
behind. Furthermore, Java and C# are not the same languages and there are parts which are quite
different.

There are some other possible inspiration resources:
- There is an existing diploma thesis (of Přemysl Vysoký at the Faculty of Mathematics and Physics,
Charles University) *Grammar to JetBrains MPS Convertor* which generates the Structure aspect from
a grammar of the language. We decided not to base our solution on the language generated by the
tool developed in this thesis because it is rather not human-readable and that would prevent further
redesigning of the language, for example in order to get better usability and user-friendliness
inside MPS. Instead, we decided to develop the whole language ourselves to really understand its
structure and to be able to efficiently redesign it when necessary.
- There are also the specification of C# 5.0 and similar resources from Microsoft. However, they
are rather designed to provide information about special cases than about the language hierarchical
structure.

# Documentation of Concepts

We documented most of the Structure aspect concepts so that future maintainers of the base
language or other developers of other base languages can more easily understand our concepts.
As a part of this documentation, we stated the name of the original grammar entity from which
the concept originated.

# Root Concepts

Every MPS language has a set of concepts marked as root concepts, i.e. concepts whose AST nodes
can become the root nodes. We decided to use only one root concept: File. As can be guessed
from the name, we were trying to reflect the traditional C# code organization. A File AST node
can contain classes, namespaces, interfaces, etc.

# Constraining the Language Structure

When designing an MPS language, one must control what the language’s user will and will not be able
to do. The goal of this effort is not to restrict the user’s freedom but it is prevention from
coding errors. Ideally, these errors should be discovered and reported to the user as soon as
possible to make his work efficient.

There are three basic ways of how to control what combinations of language entities can the user
create:
- First, the language designer may concentrate (almost) all the restrictions into the Structure
aspect by making the Structure aspect very tight. For example, in the list of inherited entities
for a class, we do not have just a list of references to those entities (i.e. list of references
of one type), but we differentiate between whether the reference goes to a class or to an
interface (i.e. list of references of two types). As in this example, in this design, there are
more Structure concepts needed to differentiate various use cases of language entities and the
relationships between the language concepts are strictly specified. The advantage of this approach
is that the language designers do not have to pay so much attention to the supporting aspects,
and that they can leave a lot of work to already functioning automation of MPS, such as auto
completion, et cetera.
- Another option is the opposite. The language designer can make the Structure aspect free and
control everything by the supporting aspects, mainly by the Constraints aspect. There he needs
to specify different rules like restrictions of what concepts, or more precisely AST nodes can be
parents or children of what. The advantage of this approach is that the Structure aspect is simple
and thus the language is more maintainable.
- The third approach is, as you may have expected, a combination of the two approaches. This may
be seen as a good option as one gets advantages of both the previous approaches but some might see
it as a bad idea of creating a dirty result.

We decided to use the third approach as we believe it is the advantages we gained by this combination, not the bad things.