public class VariableCollectorListener extends TacticBaseListener {

    /** This class will collect and handle variables during parsing.
     * The idea is that during the pass, this class will contain a
     * model with the current state of variables, and other classes
     * and listeners will request this class for information regarding
     * variables. */

    /** This listener should overwrite all / implement all method
     * regarding declarations. */

    /** TODO / Throughts
     * Fields:
     *  - mainScope - Used when in the mainScope.
     *  - functionScope - Only contains one scope. Being used when
     *                    entering a function and will be reset when
     *                    exiting a function. Should be search before
     *                    mainScope, at all times.
     *  - Scope currentScope - Used to keep track of the current scope.
     *
     * private methods:
     *  - findVariableFromIdentifier - Searches first the function scope
     *                    for a value matching the identifier, then the
     *                    mainScope. If non is found, return null.
     *
     * public methods:
     *  - .. - Used to request a value from an identifier. Will return
     *         null if value was not found.
     *  - getTypeFromIdentifier - Used to get a type from an identifier.
     *
     * Overwrites: (Everything regarding declarations and entering and exiting functions)
     * */

    /** Things to remember during implementation:
     * - Entering / exiting a scope. */







}
