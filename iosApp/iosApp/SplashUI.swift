//
//  SplashUI.swift
//  iosApp
//
//  Created by Mathieu Scotet on 05/11/2020.
//

import SwiftUI

struct SplashUI: View {
    @ObservedObject var view:SplashViewImpl
    
    /* let showAlert = Binding<Bool> {
     get { view.presentAlert }
     set { value in view.presentAlert = value }
     }
     */
    
    /*@State var isPresented : Bool {
     get {
     view.presentAlert
     }
     set(newVal) {
     view.presentAlert = newVal
     }
     }*/
    
    var body: some View {
        
        /*let isPresented = Binding<Bool>(
         get: { view.presentAlert },
         set: { newVal in view.presentAlert = newVal}
         )
         */
        return VStack {
            Text(view.title)
            Text(view.message)
            Button(action: {
                view.onTapButton()
            }, label: {
                Text("Display Alert")
            })
            Button(action: {
                view.onTapButton2()
            }, label: {
                Text("Display Alert 2")
            })
        }.alert(isPresented: Binding<Bool>(
            get: { view.presentAlert },
            set: { newVal in view.presentAlert = newVal}
        ), content: {
            let messageText:Text?  = {
                if let messT = view.messageAlert {
                    return Text(messT)
                }
                else {
                    return nil
                }
            }()
            return Alert(
                title: Text(view.titleAlert ?? "---"),
                message: messageText)
            
            
        })
        
        /*.alert(isPresented: Binding<Bool> {
         get { view.presentAlert }
         set { value in view.presentAlert = value }
         }, content: {
         Alert(title: Text("Are you sure?"),
         message: Text("Do you want to dismiss the view?"))
         })*/
        
    }
}

struct SplashUI_Previews: PreviewProvider {
    static var previews: some View {
        SplashUI(
            view: SplashViewImpl(message: "message", title: "Titre", onTapButton: {
                print("button1")
            }, onTapButton2: {
                print("button2")
            }))
    }
}
