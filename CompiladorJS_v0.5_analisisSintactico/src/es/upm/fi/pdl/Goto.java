package es.upm.fi.pdl;

public enum Goto {
	PP(30),
	S(31),
	T(32),
	IO(33),
	OP_0(34),
	OP_1(35),
	OP_2(36),
	OS(37),
	F(38),
	LF(39),
	LF1(40),
	RF(41),
	PF_0(42),
	PF_1(43),
	CF(44),
	R(45);
	public final int id;
	Goto (int id){
		this.id = id;
	}
}
