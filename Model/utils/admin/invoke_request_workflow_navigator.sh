#! /bin/sh

. ./check_env.sh

. ./set_classpath.sh $1 valdoise

java -cp $CLASSPATH  fr.cg95.cvq.util.admin.RequestWorkflowNavigator $1 "$2" $3 $4 $5
