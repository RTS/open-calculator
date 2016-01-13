package com.rts.beans;

import java.util.List;

public class OutFinancialFlowBean {

	private InFinancialFlowBean	inFinancialFlowBean;
	private List<TermBean>		termBeanList;

	/**
	 * @return the inFinancialFlowBean
	 */
	public InFinancialFlowBean getInFinancialFlowBean() {
		return inFinancialFlowBean;
	}

	/**
	 * @param inFinancialFlowBean
	 *            the inFinancialFlowBean to set
	 */
	public void setInFinancialFlowBean(InFinancialFlowBean inFinancialFlowBean) {
		this.inFinancialFlowBean = inFinancialFlowBean;
	}

	/**
	 * @return the termBeanList
	 */
	public List<TermBean> getTermBeanList() {
		return termBeanList;
	}

	/**
	 * @param termBeanList
	 *            the termBeanList to set
	 */
	public void setTermBeanList(List<TermBean> termBeanList) {
		this.termBeanList = termBeanList;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OutFinancialFlowBean [inFinancialFlowBean=" + inFinancialFlowBean + ", termBeanList=" + termBeanList
				+ "]";
	}

}
