package view;

import drawable.Line;
import drawable.Pixel;
import drawable.Poligon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import uteis.Coordenada;

/**
 *
 * @author evandro
 */
public class FrmPainel extends javax.swing.JFrame {

    private List<Coordenada> coordPoligono;

    public FrmPainel() {
        initComponents();
    }

    public void setActionAddPixel(ActionListener listner) {
        addPixel.addActionListener(listner);
    }

    public void setActionAddLine(ActionListener listner) {
        addLinha.addActionListener(listner);
    }

    public void setActionAddPoligon(ActionListener listner) {
        addPoligon.addActionListener(listner);
    }
    
    public Pixel getPixel() {
        int x = Integer.parseInt(xPixel.getText());
        int y = Integer.parseInt(yPixel.getText());
        Coordenada coordenada = new Coordenada(x, y);
        Pixel pixel = new Pixel(coordenada, edtNome.getText());
        edtNome.setText("Objeto");
        return pixel;
    }

    public Line getLine() {
        int x1 = Integer.parseInt(xEsqLinha.getText());
        int y1 = Integer.parseInt(yEsqLinha.getText());
        int x2 = Integer.parseInt(xDirLinha.getText());
        int y2 = Integer.parseInt(yDirLinha.getText());
        Coordenada start = new Coordenada(x1, y1);
        Coordenada end = new Coordenada(x2, y2);
        Line line = new Line(start, end, edtNome.getText());
        edtNome.setText("Objeto");
        return line;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        addPixel = new javax.swing.JButton();
        cancelPixel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        xPixel = new javax.swing.JTextField();
        yPixel = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        xEsqLinha = new javax.swing.JTextField();
        yEsqLinha = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        yDirLinha = new javax.swing.JTextField();
        xDirLinha = new javax.swing.JTextField();
        addLinha = new javax.swing.JButton();
        cancelLinha = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        addPoligon = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListaPoligono = new javax.swing.JList();
        xPoligon = new javax.swing.JTextField();
        yPoligon = new javax.swing.JTextField();
        addPonPol = new javax.swing.JButton();
        rmvPntPol = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        edtNome = new javax.swing.JTextField();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(20, 80));
        setResizable(false);
        setSize(new java.awt.Dimension(80, 250));

        addPixel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addPixel.setText("Adicionar");
        addPixel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPixelActionPerformed(evt);
            }
        });

        cancelPixel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cancelPixel.setText("Limpar");
        cancelPixel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelPixelActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Coordenada X:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Coordenada Y:");

        xPixel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xPixelActionPerformed(evt);
            }
        });

        yPixel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yPixelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addPixel)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(yPixel, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                        .addComponent(xPixel))
                    .addComponent(cancelPixel, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(xPixel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(yPixel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancelPixel)
                    .addComponent(addPixel))
                .addContainerGap(416, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Pixel", jPanel1);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Coordenada X esq.");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Coordenada Y esq.");

        xEsqLinha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xEsqLinhaActionPerformed(evt);
            }
        });

        yEsqLinha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yEsqLinhaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Coordenada X dir.");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Coordenada Y dir.");

        xDirLinha.setToolTipText("");
        xDirLinha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xDirLinhaActionPerformed(evt);
            }
        });

        addLinha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addLinha.setText("Adicionar");
        addLinha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addLinhaActionPerformed(evt);
            }
        });

        cancelLinha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cancelLinha.setText("Limpar");
        cancelLinha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelLinhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(xEsqLinha, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(addLinha)
                                    .addGap(20, 20, 20)))
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(xDirLinha, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(yEsqLinha, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(yDirLinha, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cancelLinha, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(xEsqLinha, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(yEsqLinha, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xDirLinha, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(yDirLinha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addLinha)
                    .addComponent(cancelLinha))
                .addContainerGap(356, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Linha", jPanel3);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Vértices");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Coordenada X:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Coordenada Y:");

        addPoligon.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addPoligon.setText("Inserir Objeto");
        addPoligon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPoligonActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(ListaPoligono);

        xPoligon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xPoligonActionPerformed(evt);
            }
        });

        yPoligon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yPoligonActionPerformed(evt);
            }
        });

        addPonPol.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addPonPol.setText("Adicionar");
        addPonPol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPonPolActionPerformed(evt);
            }
        });

        rmvPntPol.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rmvPntPol.setText("Remover");
        rmvPntPol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rmvPntPolActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jLabel7))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(xPoligon, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(addPonPol)))
                .addGap(0, 26, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(addPoligon)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(yPoligon, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rmvPntPol)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(xPoligon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addPonPol))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(yPoligon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rmvPntPol))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addPoligon)
                .addGap(18, 18, 18))
        );

        jTabbedPane1.addTab("Poligono", jPanel4);
        jPanel4.getAccessibleContext().setAccessibleName("");
        jPanel4.getAccessibleContext().setAccessibleDescription("");

        jLabel10.setText("Nome");

        edtNome.setText("Objeto");
        edtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtNomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtNome)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(jTabbedPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addPixelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPixelActionPerformed

    }//GEN-LAST:event_addPixelActionPerformed

    private void xPixelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xPixelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_xPixelActionPerformed

    private void yPixelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yPixelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yPixelActionPerformed

    private void cancelPixelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelPixelActionPerformed
        xPixel.setText("");
        yPixel.setText("");
    }//GEN-LAST:event_cancelPixelActionPerformed

    private void addLinhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addLinhaActionPerformed

    }//GEN-LAST:event_addLinhaActionPerformed

    private void xEsqLinhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xEsqLinhaActionPerformed

    }//GEN-LAST:event_xEsqLinhaActionPerformed

    private void xDirLinhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xDirLinhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_xDirLinhaActionPerformed

    private void yEsqLinhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yEsqLinhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yEsqLinhaActionPerformed

    private void cancelLinhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelLinhaActionPerformed
        xEsqLinha.setText("");
        yEsqLinha.setText("");
        xDirLinha.setText("");
        yDirLinha.setText("");
    }//GEN-LAST:event_cancelLinhaActionPerformed

    private void yPoligonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yPoligonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yPoligonActionPerformed

    private void xPoligonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xPoligonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_xPoligonActionPerformed

    private void addPonPolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPonPolActionPerformed

        if (coordPoligono == null) {
            coordPoligono = new ArrayList<>();
        }
        if (addPonPol != null) {
            int x = Integer.parseInt(xPoligon.getText());
            int y = Integer.parseInt(yPoligon.getText());
            Coordenada coordenada = new Coordenada(x, y);
            coordPoligono.add(coordenada);

            ListaPoligono.setListData(coordPoligono.toArray());
        }

    }//GEN-LAST:event_addPonPolActionPerformed

    private void rmvPntPolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rmvPntPolActionPerformed
        
        if ((!coordPoligono.isEmpty()) && (ListaPoligono.getSelectedIndex() >= 0)) {
            coordPoligono.remove(ListaPoligono.getSelectedIndex());
            ListaPoligono.setListData(coordPoligono.toArray());
            
        }
    }//GEN-LAST:event_rmvPntPolActionPerformed

    private void addPoligonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPoligonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addPoligonActionPerformed

    private void edtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtNomeActionPerformed

    public Poligon getPoligon() {
        Poligon poligon = new Poligon(coordPoligono, edtNome.getText());
        coordPoligono = new ArrayList<>();
        ListaPoligono.setListData(coordPoligono.toArray());
        edtNome.setText("Objeto");
        return poligon;
    }

    public void addPontoPol(Coordenada coordenada) {
        coordPoligono.add(coordenada);
    }

    public void removePontoPol(int index) {
        coordPoligono.remove(index);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPainel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPainel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPainel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPainel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPainel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList ListaPoligono;
    private javax.swing.JButton addLinha;
    private javax.swing.JButton addPixel;
    private javax.swing.JButton addPoligon;
    private javax.swing.JButton addPonPol;
    private javax.swing.JButton cancelLinha;
    private javax.swing.JButton cancelPixel;
    private javax.swing.JTextField edtNome;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton rmvPntPol;
    private javax.swing.JTextField xDirLinha;
    public javax.swing.JTextField xEsqLinha;
    private javax.swing.JTextField xPixel;
    private javax.swing.JTextField xPoligon;
    private javax.swing.JTextField yDirLinha;
    private javax.swing.JTextField yEsqLinha;
    private javax.swing.JTextField yPixel;
    private javax.swing.JTextField yPoligon;
    // End of variables declaration//GEN-END:variables
}
