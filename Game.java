
public abstract class Game
{
    protected boolean doContinue = true;
    public final void run()
    {
        initialize();
        loadContent();
        draw();
        while (doContinue)
		{
             userAction();
             doContinue = evaluateState();
             draw();
        }
        report();
    }
 
    protected void initialize() { }
    protected void loadContent() { }
    protected void userAction() { }
    protected void draw() { }
    protected boolean evaluateState() { return true; }
    protected void report() {};
}
