package QlangClasses2;

public abstract class Question implements QuestionInterface{
        private Result result;
        private String id;

        public Question(Result result, String id) {
            this.result = result;
            this.id = id;
        }
        public abstract Question getInstance();

        @Override
        public String getID(){
            return this.id;
        }

        public Result getResult() {
            return this.result;
        }


        /*

        public abstract String getQuestion();

        public abstract String getAnswer();
        
        public abstract String getSolution();

        */

        
}