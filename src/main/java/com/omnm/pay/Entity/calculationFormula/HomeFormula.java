package com.omnm.pay.Entity.calculationFormula;



import com.omnm.pay.enumeration.calculationFormula.OutwallType;
import com.omnm.pay.enumeration.calculationFormula.PillarType;
import com.omnm.pay.enumeration.calculationFormula.RiskLevel;
import com.omnm.pay.enumeration.calculationFormula.RoofType;
import com.omnm.pay.enumeration.calculationFormula.homeFormula.HomeCompensation;
import com.omnm.pay.enumeration.calculationFormula.homeFormula.HomeSquareMeter;
import com.omnm.pay.enumeration.calculationFormula.homeFormula.HouseType;
import com.omnm.pay.enumeration.calculationFormula.homeFormula.ResidenceType;

import java.util.HashMap;

public class HomeFormula extends CalculationFormula {

	private HashMap<ResidenceType, RiskLevel> riskLevelAccordingToResidenceType;
	private HashMap<HouseType, RiskLevel> riskLevelAccordingToHouseType;
	private HashMap<HomeSquareMeter, RiskLevel> riskLevelAccordingToSquareMeter;
	private HashMap<HomeCompensation, RiskLevel> riskLevelAccordingToCompensation;
	
	public HomeFormula(String calculationFormulaName, HashMap<PillarType, RiskLevel> riskLevelAccordingToPillarType,
					   HashMap<RoofType, RiskLevel> riskLevelAccordingToRoofType,
					   HashMap<OutwallType, RiskLevel> riskLevelAccordingToOutwallType, int numToMultiplyForMinCompensation,
					   int numToMultiplyForMaxCompensation, int numToMultiplyForPayment,
					   HashMap<ResidenceType, RiskLevel> riskLevelAccordingToResidenceType,
					   HashMap<HouseType, RiskLevel> riskLevelAccordingToHouseType,
					   HashMap<HomeSquareMeter, RiskLevel> riskLevelAccordingToSquareMeter,
					   HashMap<HomeCompensation, RiskLevel> riskLevelAccordingToCompensation) {
		super(calculationFormulaName, riskLevelAccordingToPillarType, riskLevelAccordingToRoofType,
				riskLevelAccordingToOutwallType, numToMultiplyForMinCompensation, numToMultiplyForMaxCompensation,
				numToMultiplyForPayment);
		this.riskLevelAccordingToResidenceType = riskLevelAccordingToResidenceType;
		this.riskLevelAccordingToHouseType = riskLevelAccordingToHouseType;
		this.riskLevelAccordingToSquareMeter = riskLevelAccordingToSquareMeter;
		this.riskLevelAccordingToCompensation = riskLevelAccordingToCompensation;
	}

	public HashMap<ResidenceType, RiskLevel> getRiskLevelAccordingToResidenceType() {
		return riskLevelAccordingToResidenceType;
	}

	public void setRiskLevelAccordingToResidenceType(HashMap<ResidenceType, RiskLevel> riskLevelAccordingToResidenceType) {
		this.riskLevelAccordingToResidenceType = riskLevelAccordingToResidenceType;
	}

	public HashMap<HouseType, RiskLevel> getRiskLevelAccordingToHouseType() {
		return riskLevelAccordingToHouseType;
	}

	public void setRiskLevelAccordingToHouseType(HashMap<HouseType, RiskLevel> riskLevelAccordingToHouseType) {
		this.riskLevelAccordingToHouseType = riskLevelAccordingToHouseType;
	}

	public HashMap<HomeSquareMeter, RiskLevel> getRiskLevelAccordingToSquareMeter() {
		return riskLevelAccordingToSquareMeter;
	}

	public void setRiskLevelAccordingToSquareMeter(HashMap<HomeSquareMeter, RiskLevel> riskLevelAccordingToSquareMeter) {
		this.riskLevelAccordingToSquareMeter = riskLevelAccordingToSquareMeter;
	}

	public HashMap<HomeCompensation, RiskLevel> getRiskLevelAccordingToCompensation() {
		return riskLevelAccordingToCompensation;
	}

	public void setRiskLevelAccordingToCompensation(HashMap<HomeCompensation, RiskLevel> riskLevelAccordingToCompensation) {
		this.riskLevelAccordingToCompensation = riskLevelAccordingToCompensation;
	}

}