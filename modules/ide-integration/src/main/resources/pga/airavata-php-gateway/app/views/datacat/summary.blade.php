@extends('layout.basic')
{{ HTML::script('js/datacat/jquery-1.7.min.js')}}
{{ HTML::script('js/datacat/Three.js')}}
{{ HTML::script('js/datacat/GLmol.js')}}

@section('page-header')
    @parent
@stop
@section('content')
    <div style="margin-left: 5%; margin-right: 5%; margin-top: 5px; margin-bottom: 5px">
    @if ( isset($result))
            <h1>Molecule Summary</h1>
            </br>
            <table class="table table-bordered">
                <tr>
                    <td><strong>FinalGeom</strong></td>
                    <td>
                        <div id="mol" style="width: 200px; height: 200px; background-color: black;"></div>
                        @if(isset($result['PDB']))
                            <textarea id="mol_src" style="display: none;">{{$result['PDB']}}</textarea>
                            <script type="text/javascript">
                                $( document ).ready(function() {
                                    var mol  = new GLmol('mol', true);

                                    mol.defineRepresentation = function () {
                                        var all = this.getAllAtoms();
                                        var hetatm = this.removeSolvents(this.getHetatms(all));
                                        this.colorByAtom(all, {});
                                        this.colorByChain(all);
                                        var asu = new THREE.Object3D();

                                        this.drawBondsAsStick(asu, hetatm, this.cylinderRadius, this.cylinderRadius);
                                        this.drawBondsAsStick(asu, this.getResiduesById(this.getSidechains(this.getChain(all, ['A'])), [58, 87]),
                                                this.cylinderRadius, this.cylinderRadius);
                                        this.drawBondsAsStick(asu, this.getResiduesById(this.getSidechains(this.getChain(all, ['B'])), [63, 92]),
                                                this.cylinderRadius, this.cylinderRadius);
                                        this.drawCartoon(asu, all, this.curveWidth, this.thickness);

                                        this.drawSymmetryMates2(this.modelGroup, asu, this.protein.biomtMatrices);
                                        this.modelGroup.add(asu);
                                    };

                                    mol.loadMolecule();
                                });
                            </script>
                        @endif
                    </td>
                </tr>
                <tr>
                    <td><strong>InChI</strong></td>
                    <td>@if(isset($result['InChI']))<a href="#">{{$result['InChI']}}</a>@endif</td>
                </tr>
                <tr>
                    <td><strong>InChIKey</strong></td>
                    <td>@if(isset($result['InChIKey'])){{$result['InChIKey']}}@endif</td>
                </tr>
                <tr>
                    <td><strong>SMILES</strong></td>
                    <td>@if(isset($result['SMILES'])){{$result['SMILES']}}@endif</td>
                </tr>
                <tr>
                    <td><strong>CanonicalSMILES</strong></td>
                    <td>@if(isset($result['CanonicalSMILES'])){{$result['CanonicalSMILES']}}@endif</td>
                </tr>
                @if(isset($result['Formula']))
                <tr>
                    <td><strong>Formula</strong></td>
                    <td>{{$result['Formula']}}</td>
                </tr>
                @endif
            </table>

            </br>
            <h3>Detailed Information</h3>
            <table class="table table-bordered">
                @if(isset($result['ParsedBy']))
                <tr>
                    <td><strong>ParsedBy</strong></td>
                    <td>{{$result['ParsedBy']}}</td>
                </tr>
                @endif
                @if(isset($result['Charge']))
                <tr>
                    <td><strong>Charge</strong></td>
                    <td>{{$result['Charge']}}</td>
                </tr>
                @endif
                @if(isset($result['Multiplicity']))
                <tr>
                    <td><strong>Multiplicity</strong></td>
                    <td>{{$result['Multiplicity']}}</td>
                </tr>
                @endif
                @if(isset($result['Keywords']))
                <tr>
                    <td><strong>Keywords</strong></td>
                    <td>({{$result['Keywords']}}</td>
                </tr>
                @endif
                @if(isset($result['CalcType']))
                <tr>
                    <td><strong>CalcType</strong></td>
                    <td>{{$result['CalcType']}}</td>
                </tr>
                @endif
                @if(isset($result['Methods']))
                <tr>
                    <td><strong>Methods</strong></td>
                    <td>{{$result['Methods']}}</td>
                </tr>
                @endif
                @if(isset($result['Basis']))
                <tr>
                    <td><strong>Basis</strong></td>
                    <td>{{$result['Basis']}}</td>
                </tr>
                @endif
                @if(isset($result['NumBasis']))
                <tr>
                    <td><strong>NumBasis</strong></td>
                    <td>{{$result['NumBasis']}}</td>
                </tr>
                @endif
                @if(isset($result['NumFC']))
                <tr>
                    <td><strong>NumFC</strong></td>
                    <td>{{$result['NumFC']}}</td>
                </tr>
                @endif
                @if(isset($result['NumVirt']))
                <tr>
                    <td><strong>NumVirt</strong></td>
                    <td>{{$result['NumVirt']}}</td>
                </tr>
                @endif
                    @if(isset($result['JobStatus']))
                <tr>
                    <td><strong>JobStatus</strong></td>
                    <td>{{$result['JobStatus']}}</td>
                </tr>
                    @endif
                    @if(isset($result['FinTime']))
                <tr>
                    <td><strong>FinTime</strong></td>
                    <td>{{$result['FinTime']}}</td>
                </tr>
                    @endif
                    @if(isset($result['InitGeom']))
                <tr>
                    <td><strong>InitGeom</strong></td>
                    <td>{{$result['InitGeom']}}</td>
                </tr>
                    @endif
                    @if(isset($result['FinalGeom']))
                <tr>
                    <td><strong>FinalGeom</strong></td>
                    <td>{{$result['FinalGeom']}}</td>
                </tr>
                    @endif
                    @if(isset($result['PG']))
                <tr>
                    <td><strong>PG</strong></td>
                    <td>{{$result['PG']}}</td>
                </tr>
                    @endif
                    @if(isset($result['ElecSym']))
                <tr>
                    <td><strong>ElecSym</strong></td>
                    <td>{{$result['ElecSym']}}</td>
                </tr>
                    @endif
                    @if(isset($result['NImag']))
                <tr>
                    <td><strong>NImag</strong></td>
                    <td>{{$result['NImag']}}</td>
                </tr>
                    @endif
                    @if(isset($result['Energy']))
                <tr>
                    <td><strong>Energy</strong></td>
                    <td>{{$result['Energy']}}</td>
                </tr>
                    @endif
                    @if(isset($result['EnergyKcal']))
                <tr>
                    <td><strong>EnergyKcal</strong></td>
                    <td>{{$result['EnergyKcal']}}</td>
                </tr>
                    @endif
                    @if(isset($result['ZPE']))
                <tr>
                    <td><strong>ZPE</strong></td>
                    <td>{{$result['ZPE']}}</td>
                </tr>
                    @endif
                    @if(isset($result['ZPEKcal']))
                <tr>
                    <td><strong>ZPEKcal</strong></td>
                    <td>{{$result['ZPEKcal']}}</td>
                </tr>
                    @endif
                    @if(isset($result['HF']))
                <tr>
                    <td><strong>HF</strong></td>
                    <td>{{$result['HF']}}</td>
                </tr>
                    @endif
                    @if(isset($result['HFKcal']))
                <tr>
                    <td><strong>HFKcal</strong></td>
                    <td>{{$result['HFKcal']}}</td>
                </tr>
                    @endif
                    @if(isset($result['Thermal']))
                <tr>
                    <td><strong>Thermal</strong></td>
                    <td>{{$result['Thermal']}}</td>
                </tr>
                    @endif
                    @if(isset($result['ThermalKcal']))
                <tr>
                    <td><strong>ThermalKcal</strong></td>
                    <td>{{$result['ThermalKcal']}}</td>
                </tr>
                    @endif
                    @if(isset($result['Enthalpy']))
                <tr>
                    <td><strong>Enthalpy</strong></td>
                    <td>{{$result['Enthalpy']}}</td>
                </tr>
                    @endif
                    @if(isset($result['EnthalpyKcal']))
                <tr>
                    <td><strong>EnthalpyKcal</strong></td>
                    <td>{{$result['EnthalpyKcal']}}</td>
                </tr>
                    @endif
                    @if(isset($result['Entropy']))
                <tr>
                    <td><strong>Entropy</strong></td>
                    <td>{{$result['Entropy']}}</td>
                </tr>
                    @endif
                    @if(isset($result['EntropyKcal']))
                <tr>
                    <td><strong>EntropyKcal</strong></td>
                    <td>{{$result['EntropyKcal']}}</td>
                </tr>
                    @endif
                    @if(isset($result['Gibbs']))
                <tr>
                    <td><strong>Gibbs</strong></td>
                    <td>{{$result['Gibbs']}}</td>
                </tr>
                    @endif
                    @if(isset($result['GibbsKcal']))
                <tr>
                    <td><strong>GibbsKcal</strong></td>
                    <td>{{$result['GibbsKcal']}}</td>
                </tr>
                    @endif
                    @if(isset($result['OrbSym']))
                <tr>
                    <td><strong>OrbSym</strong></td>
                    <td>{{$result['OrbSym']}}</td>
                </tr>
                    @endif
                    @if(isset($result['Dipole']))
                <tr>
                    <td><strong>Dipole</strong></td>
                    <td>{{$result['Dipole']}}</td>
                </tr>
                    @endif
                    @if(isset($result['Freq']))
                <tr>
                    <td><strong>Freq</strong></td>
                    <td>{{$result['Freq']}}</td>
                </tr>
                    @endif
                    @if(isset($result['AtomWeigh']))
                <tr>
                    <td><strong>AtomWeigh</strong></td>
                    <td>{{$result['AtomWeigh']}}</td>
                </tr>
                    @endif
                    @if(isset($result['Conditions']))
                <tr>
                    <td><strong>Conditions</strong></td>
                    <td>{{$result['Conditions']}}</td>
                </tr>
                    @endif
                    @if(isset($result['ReacGeom']))
                <tr>
                    <td><strong>ReacGeom</strong></td>
                    <td>{{$result['ReacGeom']}}</td>
                </tr>
                    @endif
                    @if(isset($result['ProdGeom']))
                <tr>
                    <td><strong>ProdGeom</strong></td>
                    <td>{{$result['ProdGeom']}}</td>
                </tr>
                    @endif
                    @if(isset($result['MulCharge']))
                <tr>
                    <td><strong>MulCharge</strong></td>
                    <td>{{$result['MulCharge']}}</td>
                </tr>
                    @endif
                    @if(isset($result['NatCharge']))
                <tr>
                    <td><strong>NatCharge</strong></td>
                    <td>{{$result['NatCharge']}}</td>
                </tr>
                    @endif
                    @if(isset($result['S2']))
                <tr>
                    <td><strong>S2</strong></td>
                    <td>{{$result['S2']}}</td>
                </tr>
                    @endif
                    @if(isset($result['CodeVersion']))
                <tr>
                    <td><strong>CodeVersion</strong></td>
                    <td>{{$result['CodeVersion']}}</td>
                </tr>
                    @endif
                    @if(isset($result['CalcMachine']))
                <tr>
                    <td><strong>CalcMachine</strong></td>
                    <td>{{$result['CalcMachine']}}</td>
                </tr>
                    @endif
                    @if(isset($result['CalcBy']))
                <tr>
                    <td><strong>CalcBy</strong></td>
                    <td>{{$result['CalcBy']}}</td>
                </tr>
                    @endif
                    @if(isset($result['MemCost']))
                <tr>
                    <td><strong>MemCost</strong></td>
                    <td>{{$result['MemCost']}}</td>
                </tr>
                    @endif
                    @if(isset($result['TimeCost']))
                <tr>
                    <td><strong>TimeCost</strong></td>
                    <td>{{$result['TimeCost']}}</td>
                </tr>
                    @endif
                    @if(isset($result['CPUTime']))
                <tr>
                    <td><strong>CPUTime</strong></td>
                    <td>{{$result['CPUTime']}}</td>
                </tr>
                    @endif
                    @if(isset($result['Convergence']))
                <tr>
                    <td><strong>Convergence</strong></td>
                    <td>{{$result['Convergence']}}</td>
                </tr>
                    @endif
                    @if(isset($result['FullPath']))
                <tr>
                    <td><strong>FullPath</strong></td>
                    <td>{{$result['FullPath']}}</td>
                </tr>
                    @endif
                    @if(isset($result['InputButGeom']))
                <tr>
                    <td><strong>InputButGeom</strong></td>
                    <td>{{$result['InputButGeom']}}</td>
                </tr>
                    @endif
                    @if(isset($result['OtherInfo']))
                <tr>
                    <td><strong>OtherInfo</strong></td>
                    <td>{{$result['OtherInfo']}}</td>
                </tr>
                    @endif
                    @if(isset($result['Comments']))
                <tr>
                    <td><strong>Comments</strong></td>
                    <td>{{$result['Comments']}}</td>
                </tr>
                    @endif
                    @if(isset($result['NAtom']))
                <tr>
                    <td><strong>NAtom</strong></td>
                    <td>{{$result['NAtom']}}</td>
                </tr>
                    @endif
                    @if(isset($result['Nmo']))
                <tr>
                    <td><strong>Nmo</strong></td>
                    <td>{{$result['Nmo']}}</td>
                </tr>
                    @endif
                    @if(isset($result['NBasis']))
                <tr>
                    <td><strong>NBasis</strong></td>
                    <td>{{$result['NBasis']}}</td>
                </tr>
                    @endif
                    @if(isset($result['AtomNos']))
                <tr>
                    <td><strong>AtomNos</strong></td>
                    <td>{{json_encode($result['AtomNos'], JSON_PRETTY_PRINT)}}</td>
                </tr>
                    @endif
                    @if(isset($result['Homos']))
                <tr>
                    <td><strong>Homos</strong></td>
                    <td>{{json_encode($result['Homos'])}}</td>
                </tr>
                    @endif
                    @if(isset($result['ScfEnergies']))
                <tr>
                    <td><strong>ScfEnerfgies</strong></td>
                    <td>{{json_encode($result['ScfEnergies'], JSON_PRETTY_PRINT)}}</td>
                </tr>
                    @endif
                    @if(isset($result['CoreElectrons']))
                <tr>
                    <td><strong>CoreElectrons</strong></td>
                    <td>{{json_encode($result['CoreElectrons'], JSON_PRETTY_PRINT)}}</td>
                </tr>
                    @endif
                    @if(isset($result['MoEnergies']))
                <tr>
                    <td><strong>MoEnergies</strong></td>
                    <td>{{json_encode($result['MoEnergies'], JSON_PRETTY_PRINT)}}</td>
                </tr>
                    @endif
                    @if(isset($result['AtomCoords']))
                <tr>
                    <td><strong>AtomCoords</strong></td>
                    <td>{{json_encode($result['AtomCoords'], JSON_PRETTY_PRINT)}}</td>
                </tr>
                    @endif
                    @if(isset($result['ScfTargets']))
                <tr>
                    <td><strong>ScfTargets</strong></td>
                    <td>{{json_encode($result['ScfTargets'], JSON_PRETTY_PRINT)}}</td>
                </tr>
                    @endif
            </table>
    @endif
    </div>
@stop