package no.hal.jex.java;

import java.lang.reflect.Method;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import no.hal.jex.AbstractRequirement;
import no.hal.jex.Exercise;
import no.hal.jex.JUnitTest;
import no.hal.jex.JavaClassTester;
import no.hal.jex.JavaMethodTester;
import no.hal.jex.JavaRequirement;
import no.hal.jex.JexPackage;
import no.hal.jex.Member;
import no.hal.jex.eval.AbstractTestAnnotationsToModelConverter;
import no.hal.jex.runtime.JExercise;

public class ReflectiveTestAnnotationsToModelConverter extends AbstractTestAnnotationsToModelConverter {

	private junit.framework.TestSuite junitTestSuite;

	public ReflectiveTestAnnotationsToModelConverter(Exercise ex, junit.framework.TestSuite junitTestSuite) {
		super(ex);
		this.junitTestSuite = junitTestSuite;
	}

	@Override
	public boolean canConvert() {
		return true;
	}

	@Override
	protected void convert(Exercise ex) {
		createFromTestClassAnnotations(junitTestSuite, null);
	}

	private ReflectionHelper reflectionHelper = new ReflectionHelper();
	
	public ReflectionHelper getReflectionHelper() {
		return reflectionHelper;
	}
	
	private JavaRequirement createFromTestClassAnnotations(junit.framework.TestSuite junitTestSuite, String packageName, String testedClassName) {
		Class<?> type = null;
		try {
			type = reflectionHelper.getReflectiveClass(junitTestSuite.getName());
		} catch (ClassNotFoundException e) {
			return null;
		}
		JExercise jexAnnotation = (JExercise) type.getAnnotation(JExercise.class);
		JavaRequirement req = ensureJavaRequirement(packageName, type.getSimpleName(), testedClassName, jexAnnotation.tests(), false);
		setAnnotationFeatures(req, jexAnnotation);
		for (int i = 0; i < junitTestSuite.testCount(); i++) {
			createFromTestClassAnnotations(junitTestSuite.testAt(i), req);
		}
		return req;
	}

	private void setAnnotationFeatures(AbstractRequirement req, JExercise jexAnnotation) {
		req.setDescription(jexAnnotation.description());
		req.setComment(jexAnnotation.comment());
	}

	private void createFromTestClassAnnotations(Test junitTest, JavaRequirement req) {
		if (junitTest instanceof TestSuite) {
			junit.framework.TestSuite junitTestSuite = (junit.framework.TestSuite) junitTest;
			String typeFullName = junitTestSuite.getName();
			if (isAllTestsName(typeFullName)) {
				for (int i = 0; i < junitTestSuite.testCount(); i++) {
					createFromTestClassAnnotations(junitTestSuite.testAt(i), req);
				}
			} else if (isTestClassName(typeFullName)) {
				String packageName = null, testedTypeName = typeFullName.substring(0, typeFullName.length() - AbstractTestAnnotationsToModelConverter.TEST_CLASS_NAME_SUFFIX.length());
				int pos = typeFullName.lastIndexOf('.');
				if (pos >= 0) {
					packageName = testedTypeName.substring(0, pos);
					testedTypeName = testedTypeName.substring(pos + 1);
				}
				createFromTestClassAnnotations(junitTestSuite, packageName, testedTypeName);
			}
		} else if (junitTest instanceof TestCase) {
			String methodName = ((TestCase) junitTest).getName();
			if (isTestMethodName(methodName)) {
				String namePrefix = AbstractTestAnnotationsToModelConverter.TEST_METHOD_NAME_PREFIX;
				String testedMethodName = Character.toLowerCase(methodName.charAt(namePrefix.length())) + methodName.substring(namePrefix.length() + 1);
				JavaClassTester javaClassTester = (JavaClassTester) req.getJavaElement();
				createFromTestMethodAnnotations((TestCase) junitTest, testedMethodName, javaClassTester, javaClassTester.getTestedElements(), req);
			}
		}
	}

	private JavaRequirement createFromTestMethodAnnotations(TestCase junitTestCase, String testedMethodName, JavaClassTester methodTesterParent, Iterable<Member> methodParent, AbstractRequirement reqParent) {
		Class<?> type = junitTestCase.getClass();
		String testMethodName = junitTestCase.getName();
		Method javaMethod = null;
		try {
			javaMethod = type.getMethod(testMethodName);
		} catch (Exception e) {
			return null;
		}
		JExercise jexAnnotation = (JExercise) javaMethod.getAnnotation(JExercise.class);
		String tests = jexAnnotation.tests();
		if (tests == null) {
			tests = testedMethodName;
		}
		JavaMethodTester javaMethodTester = (JavaMethodTester) ensureJavaElement(testMethodName, methodTesterParent.getMembers(), JexPackage.eINSTANCE.getJavaMethodTester());
		JUnitTest testReq = ensureJunitTest(javaMethodTester, tests, methodParent, reqParent);
		setAnnotationFeatures(testReq, jexAnnotation);
		return testReq;
	}
}
